package com.student.unicdastudentsapp.ui.calendario

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.CalendarWeekDay
import com.applandeo.materialcalendarview.listeners.OnCalendarDayClickListener
import com.student.unicdastudentsapp.databinding.FragmentCalendarioBinding
import com.student.unicdastudentsapp.ui.evento.EventActivity
import java.io.Serializable
import java.util.Calendar

class CalendarioFragment : Fragment() {

    private var _binding: FragmentCalendarioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calendarioViewModel =
            ViewModelProvider(this).get(CalendarioViewModel::class.java)

        _binding = FragmentCalendarioBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var calendarView = binding.calendarView

        // on click
        calendarView.setOnCalendarDayClickListener(object : OnCalendarDayClickListener {
            fun onDayClick(calendarDay: CalendarDay) {
                val clickedDayCalendar = calendarDay.calendar
                var date = clickedDayCalendar.time.date.toString()
                var events = calendarioViewModel.findEventsByDate(date);
                val intent = Intent(context, EventActivity::class.java)
                if (events.size > 0) {
                    intent.putExtra("EXTRA_EVENT", events as Serializable)
                    startActivity(intent)
                }
            }

            override fun onClick(calendarDay: CalendarDay) {
                var date = calendarDay.calendar.time.date.toString()
                var events = calendarioViewModel.findEventsByDate(date);
                val context = requireContext()
                val intent = Intent(context, EventActivity::class.java)
                if (events.size > 0) {
                    intent.putExtra("EXTRA_EVENT", events as Serializable)
                    startActivity(intent)
                }

            }
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var calendarView = binding.calendarView
        var currentDate = Calendar.getInstance();
        calendarView.setDate(currentDate);
        calendarView.setFirstDayOfWeek(CalendarWeekDay.MONDAY)
        val calendarioViewModel =
            ViewModelProvider(this).get(CalendarioViewModel::class.java)
        calendarView.setCalendarDays(calendarioViewModel.getEventDays());
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }


}
