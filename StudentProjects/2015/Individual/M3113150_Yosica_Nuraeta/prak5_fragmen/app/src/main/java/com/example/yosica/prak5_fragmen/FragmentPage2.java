package com.example.yosica.prak5_fragmen;

/**
 * Created by yosica on 1/4/2016.
 */
public class FragmentPage2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_2, container, false);

        Button btnClose = (Button)v.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        return v;
    }
}


