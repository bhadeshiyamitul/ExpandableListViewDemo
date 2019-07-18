package com.ubrain.expandablelistviewdemo

class ExpandableListData {

    fun getData():HashMap<String,ArrayList<String>>
    {
        var expandableListDetail=HashMap<String,ArrayList<String>>()

        var cityName=ArrayList<String>()
        cityName.add("Junagadh")
        cityName.add("Ahmedabad")
        cityName.add("Surat")
        cityName.add("Gandhinagar")
        cityName.add("Baroda")
        cityName.add("Rajkot")
        cityName.add("Jamnagar")


        var country=ArrayList<String>()
        country.add("India")
        country.add("Japan")
        country.add("China")
        country.add("Germany")
        country.add("Brazil")


        var state=ArrayList<String>()
        state.add("Gujarat")
        state.add("Rajsthan")
        state.add("Maharastra")
        state.add("kerala")
        state.add("sikkim")
        state.add("Goa")
        state.add("Panjab")

        expandableListDetail.put("City Name",cityName)
        expandableListDetail.put("Country Name",country)
        expandableListDetail.put("State Name",state)

        return expandableListDetail
    }
}