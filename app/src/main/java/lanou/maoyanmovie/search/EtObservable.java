package lanou.maoyanmovie.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import rx.Observable;
import rx.Subscriber;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */

// 被观察者
public class EtObservable implements Observable.OnSubscribe<String>{
    private EditText mEditText;

    public EtObservable(EditText editText) {
        mEditText = editText;
    }

    @Override
    public void call(Subscriber<? super String> subscriber) {
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 改变文字之后的问文字信息

                subscriber.onNext(s.toString());
            }
        });
    }
}
