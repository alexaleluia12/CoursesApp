package com.alexaleluia12.courses.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alexaleluia12.courses.R


data class Course(@StringRes val name: Int, val id: Int, @DrawableRes val image: Int)

fun loadCourses(): List<Course> {
    return listOf<Course>(
        Course(name = R.string.photography, id = 462, image = R.drawable.photography),
        Course(name = R.string.architecture, id = 32, image = R.drawable.architecture),
        Course(name = R.string.business, id = 72, image = R.drawable.business),
        Course(name = R.string.crafts, id = 2, image = R.drawable.crafts),
        Course(name = R.string.culinary, id = 8, image = R.drawable.culinary),
        Course(name = R.string.design, id = 12, image = R.drawable.design),
        Course(name = R.string.drawing, id = 36, image = R.drawable.drawing),
        Course(name = R.string.fashion, id = 101, image = R.drawable.fashion),
        Course(name = R.string.film, id = 102, image = R.drawable.film),
        Course(name = R.string.gaming, id = 261, image = R.drawable.gaming),
        Course(name = R.string.lifestyle, id = 872, image = R.drawable.lifestyle),
        Course(name = R.string.music, id = 6, image = R.drawable.music),
        Course(name = R.string.painting, id = 104, image = R.drawable.painting),
        Course(name = R.string.tech, id = 5001, image = R.drawable.tech)
    )
}