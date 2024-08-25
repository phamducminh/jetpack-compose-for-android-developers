import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.WellnessTask

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter()

        // Don't do this!
//        val list = remember { mutableStateListOf<WellnessTask>() }
//        list.addAll(getWellnessTasks())

        // Do this instead. Don't need to copy
//        val list = remember {
//            mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }
//        }

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTaskList(
            list = list,
            onCloseTask = { task -> list.remove(task)}
        )
    }
}

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }