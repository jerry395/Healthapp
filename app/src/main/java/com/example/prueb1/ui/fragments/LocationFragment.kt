package com.example.prueb1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prueb1.R
import com.example.prueb1.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class LocationFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentLocationBinding?= null
    private val binding: FragmentLocationBinding get() = _binding!!
    private lateinit var eMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLocationBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_location_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        eMap = map
        eMap.uiSettings.isCompassEnabled = true
        eMap.uiSettings.isZoomControlsEnabled = true
        eMap.isTrafficEnabled = true
        eMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        val latLng = LatLng(4.805159430679035, -75.69616620903622)
        eMap.addMarker(MarkerOptions().position(latLng).title(getString(R.string.app_name)))
        eMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,14.0f))
     }
}
