package com.alexaleluia12.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
// esse tava dando erro, usei itemsIndexed
// import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexaleluia12.courses.data.Course
import com.alexaleluia12.courses.data.loadCourses
import com.alexaleluia12.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Courses()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Courses(courses: List<Course> = loadCourses()) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(courses) { _, course -> CourseItem(course = course) }
    }
}

@Composable
fun CourseItem(
    course: Course, modifier: Modifier = Modifier
        .height(68.dp)
        .padding(start = 8.dp, top = 8.dp)
) {

    Row(modifier = modifier
        .background(Color.LightGray, RoundedCornerShape(8.dp))
        .fillMaxWidth()) {
        Image(
            painter = painterResource(id = course.image),
            contentDescription = stringResource(course.name),
            modifier = Modifier
                .height(68.dp)
                .width(68.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            Text(stringResource(course.name), style = MaterialTheme.typography.bodyMedium)
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null)
                Text(
                    course.id.toString(),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesApp() {
    CoursesTheme {
        Courses()
    }
}