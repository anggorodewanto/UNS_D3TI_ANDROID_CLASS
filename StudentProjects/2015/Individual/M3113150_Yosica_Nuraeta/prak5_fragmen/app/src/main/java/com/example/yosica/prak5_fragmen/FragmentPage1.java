package com.example.yosica.prak5_fragmen;

/**
 * Created by yosica on 1/4/2016.
 */
public class FragmentPage1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_1, container, false);

        Button btnNext = (Button)v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_LONG).show();

                FragmentPage2 fragmenttwo = new FragmentPage2();
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction ft = fragmentManager.beginTransaction();

                ft.replace(R.id.content_frame, fragmenttwo);

                ft.commit();

                getActionBar().setTitle("Page 2");
            }
        });

        return v;
    }
}
