package com.ytd.framework.equipment.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tlf.basic.utils.StartActUtils;
import com.ytd.framework.R;
import com.ytd.framework.equipment.ui.fragment.AddEquipmentFragment;
import com.ytd.framework.equipment.ui.fragment.AddEquipmentFragment_;
import com.ytd.framework.equipment.ui.fragment.ListEquipmentFragment;
import com.ytd.framework.equipment.ui.fragment.ListEquipmentFragment_;
import com.ytd.framework.equipment.ui.navigator.BaseSlidingTabStripActivity;
import com.ytd.support.utils.UnFinshUtils;
import com.ytd.uikit.actionbar.ActionBarOptViewTagLevel;
import com.ytd.uikit.actionbar.OnOptClickListener;
import com.ytd.uikit.slider.IndicatorWrapPagerSlider;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * 首页界面
 * Created by ytd on 16/1/19.
 */
@EActivity(R.layout.equipment_activity)
public class EquipmentActivity extends BaseSlidingTabStripActivity {

    public static final String TAG = EquipmentActivity.class.getSimpleName();

    @ViewById(R.id.tabs)
    IndicatorWrapPagerSlider mTabs;
    @ViewById(R.id.pager)
    ViewPager mPager;
    private ListEquipmentFragment listFragment;
    private AddEquipmentFragment addFragment;
    @AfterViews
    void init() {
        initActionBar();
        actionBarView.setOnOptClickListener(new OnOptClickListener() {
            @Override
            public void onClick(View v, ActionBarOptViewTagLevel viewTag) {
                if (viewTag == ActionBarOptViewTagLevel.LEFT_ICON_DRAWABLE) {
                    StartActUtils.start(mContext, EquipmentSearchActivity_.class);
                } else if (viewTag == ActionBarOptViewTagLevel.RIGHT_ICON_DRAWABLE) {
                    UnFinshUtils.unFinshToast(mContext);
                }
            }
        });
        initPager(mTabs,mPager);
    }


    @Override
    public Fragment getFragmentItem(int position) {
        switch (position) {
            case 0:
                if (listFragment == null) {
                    listFragment =  new ListEquipmentFragment_();

                }
                return listFragment;
            case 1:
                if (addFragment == null) {
                    addFragment =new AddEquipmentFragment_();

                }
                return addFragment;

            default:
                if (listFragment == null) {
                    listFragment =new ListEquipmentFragment_();

                }
                return listFragment;

        }
    }

    @Override
    public int getStringArrayResId() {
        return R.array.sliding_tab_strip_pager;
    }


}
