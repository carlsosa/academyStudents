package com.student.unicdastudentsapp.presentation.calendario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.CalendarWeekDay
import com.applandeo.materialcalendarview.listeners.OnCalendarDayClickListener
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentCalendarioBinding
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import java.util.Calendar

class CalendarioFragment : Fragment() {

    private var _binding: FragmentCalendarioBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarioBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!UserActiveUseCase.isUserActive()){
            onDestroyView()
        }
        val calendarView = binding.calendarView
        val calendarioViewModel =
        ViewModelProvider(this, CalendarioViewModelFactory())
            .get(CalendarioViewModel::class.java)
        // current date
        val currentDate = Calendar.getInstance()
        calendarView.setDate(currentDate)
        calendarView.setFirstDayOfWeek(CalendarWeekDay.MONDAY)
        calendarioViewModel.getEventDays {
            println("fetching event days")
        }
        // on click
        calendarView.setOnCalendarDayClickListener(object : OnCalendarDayClickListener {
            override fun onClick(calendarDay: CalendarDay) {
                val date = calendarDay.calendar.time.date.toString()
                calendarioViewModel.findEventsByDate(date){ events->
                  //  val context = requireContext()
                  //  val intent = Intent(context, EventFragment::class.java)
                    if (!events.isNullOrEmpty()) {
                       // intent.putExtra("EXTRA_EVENT", events as Serializable)
                       // startActivity(intent)
                        launchFragmentB(events)
                    }
                }


            }
        });



        calendarioViewModel.eventDays_.observe(viewLifecycleOwner) { days ->
            if (days != null) {
                calendarView.setCalendarDays(days)
            }
        }


    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

    private fun launchFragmentB(extra_event: List<Event>) {
        UserActiveUseCase.setUserEvents(extra_event)
        findNavController().navigate(R.id.nav_event)
    }

}
