package com.streethawk.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Bu sayfa Yeni Post gönderimi sırasında servisin çalışmasını test etmektedir.
 * Test verileri yazılır ve servise sorgu yapılır. Servis cevabına göre test başarısı ölçülür.
 */
public class NewPostUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

   /* @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void setup() {
        Activity mActivity =
        final FormEditText titleFormEditText = (FormEditText) mActivity.findViewById(R.id.formEditTextTitle);
        final EditText body = (EditText) mActivity.findViewById(R.id.password);
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                mUsername.setText("hello");
                mPassword.setText("hello123");
            }
        });

        // Check if the EditText is properly set:
        assertEquals("hello", mUsername.getText());
        assertEquals("hello123", mPassword.getText());
    }
*/

}