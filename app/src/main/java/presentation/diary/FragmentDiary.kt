package presentation.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifeteer_aos.databinding.CalendarDayBinding
import com.example.lifeteer_aos.databinding.FragmentDiaryBinding
import com.kizitonwose.calendar.core.*
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.view.MonthDayBinder
import com.kizitonwose.calendar.view.ViewContainer
import com.kizitonwose.calendar.view.WeekDayBinder
import com.kizitonwose.calendar.view.WeekScrollListener
import java.time.LocalDate
import java.time.YearMonth

class FragmentDiary : Fragment() {
    private lateinit var binding: FragmentDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(inflater, container, false)

        with(binding) {
            weekCalendarView.dayBinder = object : WeekDayBinder<DayViewContainer> {
                // Called only when a new container is needed.
                override fun create(view: View) = DayViewContainer(view)

                // Called every time we need to reuse a container.
                override fun bind(container: DayViewContainer, data: WeekDay) {
                    container.day = data
                    container.textView.text = data.date.dayOfMonth.toString()
                }
            }

            var weekScrollListener: WeekScrollListener? = null
            val currentDate = LocalDate.now()
            val currentMonth = YearMonth.now()
            val daysOfWeek = daysOfWeek()

            weekCalendarView.setup(currentDate, currentDate, daysOfWeek.first())

            extendedFAB.setOnClickListener {
                when(extendedFAB.isExtended){
                    true -> extendedFAB.shrink()
                    false -> extendedFAB.extend()
                }
            }

        }


        return binding.root    }

}
class DayViewContainer(view: View) : ViewContainer(view) {
    // With ViewBinding
    val textView = CalendarDayBinding.bind(view).calendarDayText
    // Will be set when this container is bound
    lateinit var day: WeekDay
    private var selectedDate: LocalDate? = null
    init {
        view.setOnClickListener {
            // Check the day position as we do not want to select in or out dates.
//            if (day.position == DayPosition.MonthDate) {
//                // Keep a reference to any previous selection
//                // in case we overwrite it and need to reload it.
//                val currentSelection = selectedDate
//                if (currentSelection == day.date) {
//                    // If the user clicks the same date, clear selection.
//                    selectedDate = null
//
//                } else {
//                    selectedDate = day.date
//
//                    if (currentSelection != null) {
//                    }
//                }
//            }
        }
    }
}