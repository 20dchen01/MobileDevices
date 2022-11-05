package com.example.week_5B_solution;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006B\u001d\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J%\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/example/week_5B_solution/MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/week_5B_solution/MyAdapter$ViewHolder;", "items", "", "Lcom/example/week_5B_solution/data/ImageData;", "(Ljava/util/List;)V", "cont", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/util/List;)V", "context", "cacheThumbnailBitmap", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemCount", "", "makeThumbnail", "uri", "Landroid/net/Uri;", "useloadThumbnail", "", "(Landroid/net/Uri;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "app_debug"})
public final class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.week_5B_solution.MyAdapter.ViewHolder> {
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.week_5B_solution.MyAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<com.example.week_5B_solution.data.ImageData> items;
    
    public MyAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.week_5B_solution.data.ImageData> items) {
        super();
    }
    
    public MyAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context cont, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.week_5B_solution.data.ImageData> items) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.week_5B_solution.MyAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.week_5B_solution.MyAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * All functions that could block the main thread should be marked as suspending functions.
     * This forces the consumer to dispatch them to a background thread.
     *
     * This function makes a thumbnail as a bitmap - created to make it easy to choose
     * between calling decodeSampledBitmapFromResource() and contentResolver.loadThumbnail()
     */
    private final java.lang.Object makeThumbnail(android.net.Uri uri, boolean useloadThumbnail, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation) {
        return null;
    }
    
    /**
     * All functions that could block the main thread should be marked as suspending functions.
     * This forces the consumer to dispatch them to a background thread.
     *
     * Function takes a bitmap (thumbnail in this use case) and saves the bitmap to
     * cache as a jpeg file. Returns a File object pointing to the image file
     */
    private final java.lang.Object cacheThumbnailBitmap(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super java.io.File> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/week_5B_solution/MyAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imageView;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImageView() {
            return null;
        }
        
        public final void setImageView(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J1\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/week_5B_solution/MyAdapter$Companion;", "", "()V", "items", "", "Lcom/example/week_5B_solution/data/ImageData;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "(Landroid/graphics/BitmapFactory$Options;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeSampledBitmapFromResource", "Landroid/graphics/Bitmap;", "uri", "Landroid/net/Uri;", "resolver", "Landroid/content/ContentResolver;", "(Landroid/net/Uri;IILandroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.week_5B_solution.data.ImageData> getItems() {
            return null;
        }
        
        public final void setItems(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.week_5B_solution.data.ImageData> p0) {
        }
        
        /**
         * All functions that could block the main thread should be marked as suspending functions.
         * This forces the consumer to dispatch them to a background thread.
         */
        private final java.lang.Object calculateInSampleSize(android.graphics.BitmapFactory.Options options, int reqWidth, int reqHeight, kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
            return null;
        }
        
        /**
         * All functions that could block the main thread should be marked as suspending functions.
         * This forces the consumer to dispatch them to a background thread.
         *
         * Note the following changes from the sample you were originally provided:
         * signature now uses uri: Uri instread of filePath: String, and added resolver: ContentResolver
         * This is due to an error you might have observed - BitmapFactory.decodeFile failed to load the
         * image file. My current guess (yet to confirm) is that that library needs an update (since the app itself has
         * access permission to the file.
         *
         * Consequent of this, had to implement a workaround using ImageDecoder.decodeBitmap - which is able to
         * access the file and create an Bitmap object from it. It also nicely offers an option to reduce image quality
         * before the rest of the function resizes it into a thumbnail - reduced to 20% of the original quality here
         */
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object decodeSampledBitmapFromResource(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri, int reqWidth, int reqHeight, @org.jetbrains.annotations.NotNull()
        android.content.ContentResolver resolver, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation) {
            return null;
        }
    }
}