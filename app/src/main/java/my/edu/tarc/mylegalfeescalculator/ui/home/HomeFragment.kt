package my.edu.tarc.mylegalfeescalculator.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import my.edu.tarc.mylegalfeescalculator.R
import my.edu.tarc.mylegalfeescalculator.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root

        _binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home,
            container,false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCaculate.setOnClickListener {
            val selling_price = binding.editTextSellingPrice.text.toString().toFloat()
            val downpayment = binding.editTextDownPayment.text.toString().toFloat()
            val legalFees = ""
            val stamp_duty = ""
            val first_time = binding.checkBoxFirstTime.isChecked
            val loan = selling_price - downpayment

//           1 why got error!? == cannot use by float or double..
            if(first_time){
                if (loan == (selling_price * 0.9))
            }
        }

        binding.imageView2.setOnClickListener{
            //tel:010-1234567
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234567"))
            startActivity(intent)
        }

        binding.imageView3.setOnClickListener{
            //https:010-1234567
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https:www.netflix.com"))
            startActivity(intent)
        }

        binding.buttonReset.setOnClickListener{
            binding.editTextSellingPrice.setText("")
            binding.editTextDownPayment.setText("")
            binding.checkBoxFirstTime.setChecked(false)
            val fees = Fees("", "")
            binding.myFees = fees
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}