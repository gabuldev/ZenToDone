package example.learning.kotlin.gabriel.zendone.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import example.learning.kotlin.gabriel.zendone.R


/**
 * Created by msi on 9/11/2017.
 */
class AdapterPager(fm: FragmentManager): FragmentPagerAdapter(fm) {


    var mFm = fm
    var mFragmentItems:ArrayList<Fragment> = ArrayList()
    var mFragmentTitles:ArrayList<String> = ArrayList()

    //we need to create function to add fragments

    override fun getItemPosition(`object`: Any?): Int {
        var click = mFm.findFragmentById(R.id.frametoday)


        return super.getItemPosition(`object`)
    }
    fun addFragments(fragmentItem: Fragment, fragmentTitle:String){
        mFragmentItems.add(fragmentItem)
        mFragmentTitles.add(fragmentTitle)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentItems[position]
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitles[position]
    }

}