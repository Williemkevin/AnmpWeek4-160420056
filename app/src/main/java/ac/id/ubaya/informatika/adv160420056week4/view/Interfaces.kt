package ac.id.ubaya.informatika.adv160420056week4.view

import ac.id.ubaya.informatika.adv160420056week4.model.Student
import android.view.View

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}

interface FragmentDetailInterface{
    fun onUpdateClick(v:View, obj: Student)
}