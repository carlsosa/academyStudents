package com.student.unicdastudentsapp.ui.calendario

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.CalendarWeekDay
import com.applandeo.materialcalendarview.listeners.OnCalendarDayClickListener
import com.student.unicdastudentsapp.databinding.FragmentCalendarioBinding
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

        var calendarView =  binding.calendarView
        var currentDate = Calendar.getInstance();
        calendarView.setDate(currentDate);
        calendarView.setFirstDayOfWeek(CalendarWeekDay.MONDAY)
        calendarView.setCalendarDays(calendarioViewModel.getEventDays());
        // on click
        calendarView.setOnCalendarDayClickListener(object : OnCalendarDayClickListener {
            fun onDayClick(calendarDay: CalendarDay) {
                val clickedDayCalendar = calendarDay.calendar
                var date = clickedDayCalendar.time.date.toString()
                var events =calendarioViewModel.findEventsByDate(date);
            }

            override fun onClick(calendarDay: CalendarDay) {
               var date = calendarDay.calendar.time.date.toString()
                var events =calendarioViewModel.findEventsByDate(date);

            }
        })
        return root
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }



}
