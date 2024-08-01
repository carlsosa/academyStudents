package com.student.unicdastudentsapp.ui.calendario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.databinding.FragmentCalendarioBinding
import java.util.TimeZone

class CalendarioFragment() : Fragment() {

    private var _binding: FragmentCalendarioBinding? = null

    lateinit var dateSel: TextView
    lateinit var calendarView: CalendarView
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
        dateSel = binding.idDateShow
        calendarView = binding.calendarView
        calendarView.firstDayOfWeek =2
        calendarView
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)
                    dateSel.setText(Date)

                });


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
