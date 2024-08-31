import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        // Don't do this!
//        val list = remember { mutableStateListOf<WellnessTask>() }
//        list.addAll(getWellnessTasks())

        // Do this instead. Don't need to copy
//        val list = remember {
//            mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }
//        }

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}