package ac.id.ubaya.informatika.adv160420056week4.viewmodel

import ac.id.ubaya.informatika.adv160420056week4.model.Student
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1
    }

}