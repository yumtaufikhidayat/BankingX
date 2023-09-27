package com.taufik.bankingx.ui.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentMonthActivityBinding
import com.taufik.bankingx.ui.activity.viewmodel.ChartDatasetViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MonthActivityFragment : Fragment() {

    private var _binding: FragmentMonthActivityBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ChartDatasetViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setChartData()
    }

    private fun setChartData() {
        binding.apply {
            val chartDataset = viewModel.getAllChartDataset()
            val lineDataSet = LineDataSet(chartDataset, "")
            lineDataSet.apply {
                circleRadius = 10f
                setDrawFilled(true)
                valueTextSize = 12F
                mode = LineDataSet.Mode.HORIZONTAL_BEZIER
            }

            val xAxisLabels = ArrayList<String>()
            xAxisLabels.apply {
                add("Jan")
                add("Feb")
                add("Mar")
                add("Apr")
                add("May")
                add("Jun")
                add("Jul")
                add("Aug")
                add("Sep")
                add("Oct")
                add("Nov")
                add("Dec")
            }

            with(lineChart) {
                val xAxiss = this.xAxis
                this.data = LineData(lineDataSet)
                setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                animateXY(DURATION_TIME, DURATION_TIME, Easing.EaseInCubic)
                setTouchEnabled(true)
                setPinchZoom(true)
                setDrawGridBackground(false)
                setDrawMarkers(false)
                xAxiss.setDrawGridLines(false)
                description.isEnabled = false
                axisLeft.isEnabled = false
                axisRight.isEnabled = false
                xAxis.setDrawAxisLine(false)
                isDragEnabled = false
                setScaleEnabled(true)
                xAxiss.setDrawLabels(true)
                xAxiss.setCenterAxisLabels(true)
                xAxiss.position = XAxisPosition.BOTTOM
                xAxiss.isGranularityEnabled = true
                xAxiss.granularity = 0f
                xAxiss.valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        val indexOfData = chartDataset.indexOfFirst {
                            it.x == value
                        }
                        return when(indexOfData) {
                            in 0 until 12 -> xAxisLabels[indexOfData]
                            else -> ""
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val DURATION_TIME = 1000
    }
}