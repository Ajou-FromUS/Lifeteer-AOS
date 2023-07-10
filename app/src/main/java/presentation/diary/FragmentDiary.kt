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
        binding.weekCalendarView.dayBinder = object : WeekDayBinder<DayViewContainer> {

            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(container: DayViewContainer, data: WeekDay) {
                container.textView.text = data.date.dayOfMonth.toString()
            }
        }
        val currentDate = LocalDate.now()
        val currentMonth = YearMonth.now()
        val startDate = currentMonth.minusMonths(1).atStartOfMonth() // Adjust as needed
        val endDate = currentMonth.plusMonths(6).atEndOfMonth()  // Adjust as needed
        val daysOfWeek = daysOfWeek()
        with(binding) {
            weekCalendarView.setup(startDate, endDate, daysOfWeek.first())
            weekCalendarView.scrollToWeek(currentDate)
        }

        return binding.root    }

}
class DayViewContainer(view: View) : ViewContainer(view) {
    // With ViewBinding
    val textView = CalendarDayBinding.bind(view).calendarDayText
}