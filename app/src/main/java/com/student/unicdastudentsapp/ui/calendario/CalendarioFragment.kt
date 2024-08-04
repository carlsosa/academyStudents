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
import com.student.unicdastudentsapp.ui.data.model.UserActive
import com.student.unicdastudentsapp.ui.evento.EventActivity
import java.io.Serializable
import java.util.Calendar

class CalendarioFragment : Fragment() {

    private var _binding: FragmentCalendarioBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[CalendarioViewModel::class.java]
        _binding = FragmentCalendarioBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!UserActive.isUserActive()){
            onDestroyView()
        }
        val calendarView = binding.calendarView
        val calendarioViewModel =
            ViewModelProvider(this)[CalendarioViewModel::class.java]
        calendarView.setOnCalendarDayClickListener(object : OnCalendarDayClickListener {
            override fun onClick(calendarDay: CalendarDay) {
                val date = calendarDay.calendar.time.date.toString()
                val events = calendarioViewModel.findEventsByDate(date)
                val context = requireContext()
                val intent = Intent(context, EventActivity::class.java)
                if (events.isNotEmpty()) {
                    intent.putExtra("EXTRA_EVENT", events as Serializable)
                    startActivity(intent)
                }

            }
        })


        val currentDate = Calendar.getInstance()
        calendarView.setDate(currentDate)
        calendarView.setFirstDayOfWeek(CalendarWeekDay.MONDAY)
        calendarView.setCalendarDays(calendarioViewModel.getEventDays())

    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }


}
