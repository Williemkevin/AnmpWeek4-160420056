package ac.id.ubaya.informatika.adv160420056week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.id.ubaya.informatika.adv160420056week4.R
import ac.id.ubaya.informatika.adv160420056week4.databinding.FragmentStudentDetailBinding
import ac.id.ubaya.informatika.adv160420056week4.model.Student
import ac.id.ubaya.informatika.adv160420056week4.util.loadImage
import ac.id.ubaya.informatika.adv160420056week4.viewmodel.DetailViewModel
import android.annotation.SuppressLint
import android.database.Observable
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(), FragmentDetailInterface {
    private lateinit var detailModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId

        detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailModel.fetch(studentId)

        observeViewModel()
    }

    @SuppressLint("CheckResult")
    fun observeViewModel(){
        detailModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.detailStudent = it
//            val pb = view?.findViewById<ProgressBar>(R.id.progressBarDetail)
//            view?.findViewById<ImageView>(R.id.imageDetail)?.loadImage(detailModel.studentLD.value?.photoUrl,
//                pb!!
//            )
//            view?.findViewById<TextInputEditText>(R.id.txtID)?.setText(detailModel.studentLD.value?.id)
//            view?.findViewById<TextInputEditText>(R.id.txtName)?.setText(detailModel.studentLD.value?.name)
//            view?.findViewById<TextInputEditText>(R.id.txtBod)?.setText(detailModel.studentLD.value?.bod)
//            view?.findViewById<TextInputEditText>(R.id.txtPhone)?.setText(detailModel.studentLD.value?.phone)
//
//            var student = it
//            view?.findViewById<Button>(R.id.btnNotif)?.setOnClickListener{
//                io.reactivex.rxjava3.core.Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.baseline_error_24)
//                    }
//            }

        })
    }

    override fun onUpdateClick(v: View, obj: Student) {
        TODO("Not yet implemented")
    }
}