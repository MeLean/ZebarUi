package homemade.com.zebarui.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import homemade.com.zebarui.R;
import homemade.com.zebarui.constants.Preferences;
import homemade.com.zebarui.ui.activities.WidgetActivity;


public class OfferTabulatedFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    public OfferTabulatedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer_tabulated, container, false);

        //set the dropdown
        Spinner spinner = (Spinner) view.findViewById(R.id.sp_offers_header_dropdown);
        spinner.setPrompt(getString(R.string.offers_sort_by_text));

        spinner.setAdapter(new ArrayAdapter<>(
                getContext(),
                R.layout.spinner_dropdown_item,
                getResources().getStringArray(R.array.offers_sort_values))
        );

        view.findViewById(R.id.offer_item).setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.offer_item) {
            Intent intent = new Intent(getContext(), WidgetActivity.class);
            intent.putExtra(Preferences.FRAGMENT_NAME, Preferences.OFFERS);
            this.startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //todo make actions on option selected

        Toast.makeText(getContext(), "Item has been selected: " + view.getLayerType(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //do nothing
    }
}
