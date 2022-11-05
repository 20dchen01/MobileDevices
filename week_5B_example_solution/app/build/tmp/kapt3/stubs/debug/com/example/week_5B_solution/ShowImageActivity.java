package com.example.week_5B_solution;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/week_5B_solution/ShowImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/week_5B_solution/databinding/ActivityShowImageBinding;", "daoObj", "Lcom/example/week_5B_solution/data/ImageDataDao;", "loadImageView", "", "position", "", "defaultToPath", "", "loadImageViewWithMediaStore", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadImageViewWithPath", "path", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteButtonClickListener", "view", "Landroid/view/View;", "onUpdateButtonClickListener", "app_debug"})
public final class ShowImageActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.week_5B_solution.databinding.ActivityShowImageBinding binding;
    private com.example.week_5B_solution.data.ImageDataDao daoObj;
    
    public ShowImageActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * This function will either use the file path to load the image by default
     * Or can load from MediaStore when defaultToPath is false and the
     * path host contains "com.android".
     */
    private final void loadImageView(int position, boolean defaultToPath) {
    }
    
    /**
     * function that loads images based on the image's file path only
     */
    private final void loadImageViewWithPath(java.lang.String path) {
    }
    
    /**
     * function that loads images from media store. Queries for the image
     * using the id. Note, image may no longer exists in storage, or
     * might have been backed up to Google Photos, which might take a while to
     * retrieve. Retrieval will fail if there is no Internet connection.
     *
     * This is a basic media store access implementation. Media store query works
     * similar to running an SQL query
     */
    private final java.lang.Object loadImageViewWithMediaStore(java.lang.String id, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void onUpdateButtonClickListener(android.view.View view, int position) {
    }
    
    private final void onDeleteButtonClickListener(android.view.View view, int position) {
    }
}