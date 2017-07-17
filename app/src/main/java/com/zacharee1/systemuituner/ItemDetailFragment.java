package com.zacharee1.systemuituner;

import android.app.Activity;
import android.preference.PreferenceFragment;
import android.os.Bundle;

import com.zacharee1.systemuituner.Activites.ItemDetailActivity;
import com.zacharee1.systemuituner.Activites.ItemListActivity;
import com.zacharee1.systemuituner.FragmentHelpers.DemoHelper;
import com.zacharee1.systemuituner.FragmentHelpers.MiscHelper;
import com.zacharee1.systemuituner.FragmentHelpers.QSHelper;
import com.zacharee1.systemuituner.FragmentHelpers.StatbarHelper;
import com.zacharee1.systemuituner.FragmentHelpers.TWHelper;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends PreferenceFragment
{
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private TweakItems.TweakItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            final String id = getArguments().getString(ARG_ITEM_ID);
            assert id != null;

            mItem = TweakItems.ITEM_MAP.get(id);
            addPreferencesFromResource(mItem.layoutId);

            switch (id) {
                case "statbar":
                    new StatbarHelper(this);
                    break;
                case "qs":
                    new QSHelper(this);
                    break;
                case "demo":
                    new DemoHelper(this);
                    break;
                case "touchwiz":
                    new StatbarHelper(this);
                    new TWHelper(this);
                    break;
                case "misc":
                    new MiscHelper(this);
                    break;
            }

            getActivity().setTitle(mItem.content);
        }
    }
}
