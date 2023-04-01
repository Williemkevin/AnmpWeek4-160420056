package ac.id.ubaya.informatika.adv160420056week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.id.ubaya.informatika.adv160420056week4.R
import ac.id.ubaya.informatika.adv160420056week4.viewmodel.DetailViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class StudentDetailFragment : Fragment() {
    private lateinit var detailModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailModel.fetch()

        observeViewModel()
    }

    fun observeViewModel(){
        detailModel.studentLD.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextInputEditText>(R.id.txtID)?.setText(detailModel.studentLD.value?.id)
            view?.findViewById<TextInputEditText>(R.id.txtName)?.setText(detailModel.studentLD.value?.name)
            view?.findViewById<TextInputEditText>(R.id.txtBod)?.setText(detailModel.studentLD.value?.bod)
            view?.findViewById<TextInputEditText>(R.id.txtPhone)?.setText(detailModel.studentLD.value?.phone)
        })
    }
}