package com.limuealimi.islamicglobalmessengerfromyasimin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentHomeBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.models.UserData
import com.limuealimi.islamicglobalmessengerfromyasimin.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var result: Int = -1
    var specialCode = -1
    val manColor = R.color.manColorOne
    val womanColor = R.color.womanColorOne
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.apply {

            loadingBtn.setOnClickListener {
                loadingBtn.startLoading()
                var userName = checkName.editText?.text.toString()

                when {
                    userName.contains("jon") -> {
                        specialCode = 1
                        userName = userName.substringBeforeLast("jon")
                    }
                    userName.contains("bonu") -> {
                        specialCode = 2
                        userName = userName.substringBeforeLast("bonu")
                    }
                    userName.contains("bek") -> {
                        specialCode = 3
                        userName = userName.substringBeforeLast("bek")
                    }
                    userName.contains("begim") -> {
                        specialCode = 4
                        userName = userName.substringBeforeLast("begim")
                    }
                }
                try {
                    ApiClient.apiService.nameCheck(userName)
                        .enqueue(object : Callback<UserData> {
                            /** On Response is Successful **/
                            override fun onResponse(
                                call: Call<UserData>,
                                response: Response<UserData>
                            ) {
                                if (response.isSuccessful) {
                                    // loadingBtn.loadingSuccessful()
                                    try {
                                        val userData = response.body()
                                        Toast.makeText(
                                            requireContext(),
                                            userData?.gender,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        when (userData?.gender) {
                                            "male" -> {
                                                result = manColor
                                            }
                                            "female" -> {
                                                result = womanColor
                                            }
                                            "null" -> {
                                                loadingBtn.loadingFailed()
                                                Toast.makeText(
                                                    requireContext(),
                                                    "Iltimos, faqatgina ismingizni kiritishingizni so'raymiz!",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            }
                                            else -> {
                                                loadingBtn.loadingFailed()
                                            }
                                        }
                                        when (specialCode) {
                                            1 -> {
                                                userName += "jon"
                                                specialCode = 0
                                            }
                                            2 -> {
                                                userName += "bonu"
                                                specialCode = 0
                                            }
                                            3 -> {
                                                userName += "bek"
                                                specialCode = 0
                                            }
                                            4 -> {
                                                userName += "begim"
                                                specialCode = 0
                                            }
                                        }
                                        setFragmentResult(
                                            "requestKey",
                                            bundleOf("bundleKey" to result)
                                        )
                                        findNavController().navigate(R.id.action_homeFragment_to_userProfileFragment)
                                    } catch (ex: Exception) {
                                        if (context != null) {
                                            loadingBtn.loadingFailed()
                                            Toast.makeText(
                                                requireContext(),
                                                "Iltimos, faqatgina ismingizni kiritishingizni so'raymiz!",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        }
                                    }
                                } else {
                                    loadingBtn.loadingFailed()
                                }
                            }

                            /** On Failure **/
                            override fun onFailure(call: Call<UserData>, t: Throwable) {
                                loadingBtn.loadingFailed()
                            }
                        })
                } catch (ex: Exception) {
                    if (context != null) {
                        Toast.makeText(requireContext(), ex.localizedMessage, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        return binding.root
    }
}