package ac.id.ubaya.informatika.adv160420056week4.viewmodel

import ac.id.ubaya.informatika.adv160420056week4.model.Student
import ac.id.ubaya.informatika.adv160420056week4.view.StudentDetailFragment
//import ac.id.ubaya.informatika.adv160420056week4.view.StudentDetailFragmentArgs
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//class DetailViewModel:ViewModel() {
class DetailViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(studentID : String) {
//        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=$studentID"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
            val result = Gson().fromJson<Student>(it, Student::class.java)
            studentLD.value = result
            Log.d("showdetail", result.toString())
        },
            {
                Log.d("showdetail", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
//        studentLD.value = student1
    }

}