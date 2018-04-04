package com.johnhao.demo.downloadPractice;

/**
 * Created by johnhao on 2018/4/2.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCancled();
}
