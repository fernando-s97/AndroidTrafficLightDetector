
//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Point;
import org.opencv.utils.Converters;

import java.util.List;

// C++: class Photo
//javadoc: Photo

public class Photo {
    
    public static final int
            INPAINT_NS = 0,
            INPAINT_TELEA = 1,
            NORMAL_CLONE = 1,
            MIXED_CLONE = 2,
            MONOCHROME_TRANSFER = 3,
            RECURS_FILTER = 1,
            NORMCONV_FILTER = 2,
            LDR_SIZE = 256;
    private static final int
            CV_INPAINT_NS = 0,
            CV_INPAINT_TELEA = 1;
    
    
    //
    // C++:  Ptr_AlignMTB createAlignMTB(int max_bits = 6, int exclude_range = 4, bool cut = true)
    //
    
    //javadoc: createAlignMTB(max_bits, exclude_range, cut)
    public static AlignMTB createAlignMTB(int max_bits, int exclude_range, boolean cut) {
        
        AlignMTB retVal = new AlignMTB(createAlignMTB_0(max_bits, exclude_range, cut));
        
        return retVal;
    }
    
    // C++:  Ptr_AlignMTB createAlignMTB(int max_bits = 6, int exclude_range = 4, bool cut = true)
    private static native long createAlignMTB_0(int max_bits, int exclude_range, boolean cut);
    
    
    //
    // C++:  Ptr_CalibrateDebevec createCalibrateDebevec(int samples = 70, float lambda = 10.0f, bool random = false)
    //
    
    //javadoc: createAlignMTB()
    public static AlignMTB createAlignMTB() {
        
        AlignMTB retVal = new AlignMTB(createAlignMTB_1());
        
        return retVal;
    }
    
    private static native long createAlignMTB_1();
    
    
    //
    // C++:  Ptr_CalibrateRobertson createCalibrateRobertson(int max_iter = 30, float threshold = 0.01f)
    //
    
    //javadoc: createCalibrateDebevec(samples, lambda, random)
    public static CalibrateDebevec createCalibrateDebevec(int samples, float lambda, boolean random) {
        
        CalibrateDebevec retVal = new CalibrateDebevec(createCalibrateDebevec_0(samples, lambda, random));
        
        return retVal;
    }
    
    // C++:  Ptr_CalibrateDebevec createCalibrateDebevec(int samples = 70, float lambda = 10.0f, bool random = false)
    private static native long createCalibrateDebevec_0(int samples, float lambda, boolean random);
    
    
    //
    // C++:  Ptr_MergeDebevec createMergeDebevec()
    //
    
    //javadoc: createCalibrateDebevec()
    public static CalibrateDebevec createCalibrateDebevec() {
        
        CalibrateDebevec retVal = new CalibrateDebevec(createCalibrateDebevec_1());
        
        return retVal;
    }
    
    
    //
    // C++:  Ptr_MergeMertens createMergeMertens(float contrast_weight = 1.0f, float saturation_weight = 1.0f, float exposure_weight = 0.0f)
    //
    
    private static native long createCalibrateDebevec_1();
    
    //javadoc: createCalibrateRobertson(max_iter, threshold)
    public static CalibrateRobertson createCalibrateRobertson(int max_iter, float threshold) {
        
        CalibrateRobertson retVal = new CalibrateRobertson(createCalibrateRobertson_0(max_iter, threshold));
        
        return retVal;
    }
    
    
    //
    // C++:  Ptr_MergeRobertson createMergeRobertson()
    //
    
    // C++:  Ptr_CalibrateRobertson createCalibrateRobertson(int max_iter = 30, float threshold = 0.01f)
    private static native long createCalibrateRobertson_0(int max_iter, float threshold);
    
    
    //
    // C++:  Ptr_Tonemap createTonemap(float gamma = 1.0f)
    //
    
    //javadoc: createCalibrateRobertson()
    public static CalibrateRobertson createCalibrateRobertson() {
        
        CalibrateRobertson retVal = new CalibrateRobertson(createCalibrateRobertson_1());
        
        return retVal;
    }
    
    private static native long createCalibrateRobertson_1();
    
    
    //
    // C++:  Ptr_TonemapDrago createTonemapDrago(float gamma = 1.0f, float saturation = 1.0f, float bias = 0.85f)
    //
    
    //javadoc: createMergeDebevec()
    public static MergeDebevec createMergeDebevec() {
        
        MergeDebevec retVal = new MergeDebevec(createMergeDebevec_0());
        
        return retVal;
    }
    
    // C++:  Ptr_MergeDebevec createMergeDebevec()
    private static native long createMergeDebevec_0();
    
    
    //
    // C++:  Ptr_TonemapDurand createTonemapDurand(float gamma = 1.0f, float contrast = 4.0f, float saturation = 1.0f, float sigma_space = 2.0f, float sigma_color = 2.0f)
    //
    
    //javadoc: createMergeMertens(contrast_weight, saturation_weight, exposure_weight)
    public static MergeMertens createMergeMertens(float contrast_weight, float saturation_weight, float exposure_weight) {
        
        MergeMertens retVal = new MergeMertens(createMergeMertens_0(contrast_weight, saturation_weight, exposure_weight));
        
        return retVal;
    }
    
    // C++:  Ptr_MergeMertens createMergeMertens(float contrast_weight = 1.0f, float saturation_weight = 1.0f, float exposure_weight = 0.0f)
    private static native long createMergeMertens_0(float contrast_weight, float saturation_weight, float exposure_weight);
    
    
    //
    // C++:  Ptr_TonemapMantiuk createTonemapMantiuk(float gamma = 1.0f, float scale = 0.7f, float saturation = 1.0f)
    //
    
    //javadoc: createMergeMertens()
    public static MergeMertens createMergeMertens() {
        
        MergeMertens retVal = new MergeMertens(createMergeMertens_1());
        
        return retVal;
    }
    
    private static native long createMergeMertens_1();
    
    
    //
    // C++:  Ptr_TonemapReinhard createTonemapReinhard(float gamma = 1.0f, float intensity = 0.0f, float light_adapt = 1.0f, float color_adapt = 0.0f)
    //
    
    //javadoc: createMergeRobertson()
    public static MergeRobertson createMergeRobertson() {
        
        MergeRobertson retVal = new MergeRobertson(createMergeRobertson_0());
        
        return retVal;
    }
    
    // C++:  Ptr_MergeRobertson createMergeRobertson()
    private static native long createMergeRobertson_0();
    
    
    //
    // C++:  void colorChange(Mat src, Mat mask, Mat& dst, float red_mul = 1.0f, float green_mul = 1.0f, float blue_mul = 1.0f)
    //
    
    //javadoc: createTonemap(gamma)
    public static Tonemap createTonemap(float gamma) {
        
        Tonemap retVal = new Tonemap(createTonemap_0(gamma));
        
        return retVal;
    }
    
    // C++:  Ptr_Tonemap createTonemap(float gamma = 1.0f)
    private static native long createTonemap_0(float gamma);
    
    
    //
    // C++:  void decolor(Mat src, Mat& grayscale, Mat& color_boost)
    //
    
    //javadoc: createTonemap()
    public static Tonemap createTonemap() {
        
        Tonemap retVal = new Tonemap(createTonemap_1());
        
        return retVal;
    }
    
    
    //
    // C++:  void denoise_TVL1(vector_Mat observations, Mat result, double lambda = 1.0, int niters = 30)
    //
    
    private static native long createTonemap_1();
    
    //javadoc: createTonemapDrago(gamma, saturation, bias)
    public static TonemapDrago createTonemapDrago(float gamma, float saturation, float bias) {
        
        TonemapDrago retVal = new TonemapDrago(createTonemapDrago_0(gamma, saturation, bias));
        
        return retVal;
    }
    
    
    //
    // C++:  void detailEnhance(Mat src, Mat& dst, float sigma_s = 10, float sigma_r = 0.15f)
    //
    
    // C++:  Ptr_TonemapDrago createTonemapDrago(float gamma = 1.0f, float saturation = 1.0f, float bias = 0.85f)
    private static native long createTonemapDrago_0(float gamma, float saturation, float bias);
    
    //javadoc: createTonemapDrago()
    public static TonemapDrago createTonemapDrago() {
        
        TonemapDrago retVal = new TonemapDrago(createTonemapDrago_1());
        
        return retVal;
    }
    
    
    //
    // C++:  void edgePreservingFilter(Mat src, Mat& dst, int flags = 1, float sigma_s = 60, float sigma_r = 0.4f)
    //
    
    private static native long createTonemapDrago_1();
    
    //javadoc: createTonemapDurand(gamma, contrast, saturation, sigma_space, sigma_color)
    public static TonemapDurand createTonemapDurand(float gamma, float contrast, float saturation, float sigma_space, float sigma_color) {
        
        TonemapDurand retVal = new TonemapDurand(createTonemapDurand_0(gamma, contrast, saturation, sigma_space, sigma_color));
        
        return retVal;
    }
    
    
    //
    // C++:  void fastNlMeansDenoising(Mat src, Mat& dst, float h = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    //
    
    // C++:  Ptr_TonemapDurand createTonemapDurand(float gamma = 1.0f, float contrast = 4.0f, float saturation = 1.0f, float sigma_space = 2.0f, float sigma_color = 2.0f)
    private static native long createTonemapDurand_0(float gamma, float contrast, float saturation, float sigma_space, float sigma_color);
    
    //javadoc: createTonemapDurand()
    public static TonemapDurand createTonemapDurand() {
        
        TonemapDurand retVal = new TonemapDurand(createTonemapDurand_1());
        
        return retVal;
    }
    
    
    //
    // C++:  void fastNlMeansDenoising(Mat src, Mat& dst, vector_float h, int templateWindowSize = 7, int searchWindowSize = 21, int normType = NORM_L2)
    //
    
    private static native long createTonemapDurand_1();
    
    //javadoc: createTonemapMantiuk(gamma, scale, saturation)
    public static TonemapMantiuk createTonemapMantiuk(float gamma, float scale, float saturation) {
        
        TonemapMantiuk retVal = new TonemapMantiuk(createTonemapMantiuk_0(gamma, scale, saturation));
        
        return retVal;
    }
    
    
    //
    // C++:  void fastNlMeansDenoisingColored(Mat src, Mat& dst, float h = 3, float hColor = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    //
    
    // C++:  Ptr_TonemapMantiuk createTonemapMantiuk(float gamma = 1.0f, float scale = 0.7f, float saturation = 1.0f)
    private static native long createTonemapMantiuk_0(float gamma, float scale, float saturation);
    
    //javadoc: createTonemapMantiuk()
    public static TonemapMantiuk createTonemapMantiuk() {
        
        TonemapMantiuk retVal = new TonemapMantiuk(createTonemapMantiuk_1());
        
        return retVal;
    }
    
    
    //
    // C++:  void fastNlMeansDenoisingColoredMulti(vector_Mat srcImgs, Mat& dst, int imgToDenoiseIndex, int temporalWindowSize, float h = 3, float hColor = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    //
    
    private static native long createTonemapMantiuk_1();
    
    //javadoc: createTonemapReinhard(gamma, intensity, light_adapt, color_adapt)
    public static TonemapReinhard createTonemapReinhard(float gamma, float intensity, float light_adapt, float color_adapt) {
        
        TonemapReinhard retVal = new TonemapReinhard(createTonemapReinhard_0(gamma, intensity, light_adapt, color_adapt));
        
        return retVal;
    }
    
    
    //
    // C++:  void fastNlMeansDenoisingMulti(vector_Mat srcImgs, Mat& dst, int imgToDenoiseIndex, int temporalWindowSize, float h = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    //
    
    // C++:  Ptr_TonemapReinhard createTonemapReinhard(float gamma = 1.0f, float intensity = 0.0f, float light_adapt = 1.0f, float color_adapt = 0.0f)
    private static native long createTonemapReinhard_0(float gamma, float intensity, float light_adapt, float color_adapt);
    
    //javadoc: createTonemapReinhard()
    public static TonemapReinhard createTonemapReinhard() {
        
        TonemapReinhard retVal = new TonemapReinhard(createTonemapReinhard_1());
        
        return retVal;
    }
    
    
    //
    // C++:  void fastNlMeansDenoisingMulti(vector_Mat srcImgs, Mat& dst, int imgToDenoiseIndex, int temporalWindowSize, vector_float h, int templateWindowSize = 7, int searchWindowSize = 21, int normType = NORM_L2)
    //
    
    private static native long createTonemapReinhard_1();
    
    //javadoc: colorChange(src, mask, dst, red_mul, green_mul, blue_mul)
    public static void colorChange(Mat src, Mat mask, Mat dst, float red_mul, float green_mul, float blue_mul) {
        
        colorChange_0(src.nativeObj, mask.nativeObj, dst.nativeObj, red_mul, green_mul, blue_mul);
        
        return;
    }
    
    
    //
    // C++:  void illuminationChange(Mat src, Mat mask, Mat& dst, float alpha = 0.2f, float beta = 0.4f)
    //
    
    // C++:  void colorChange(Mat src, Mat mask, Mat& dst, float red_mul = 1.0f, float green_mul = 1.0f, float blue_mul = 1.0f)
    private static native void colorChange_0(long src_nativeObj, long mask_nativeObj, long dst_nativeObj, float red_mul, float green_mul, float blue_mul);
    
    //javadoc: colorChange(src, mask, dst)
    public static void colorChange(Mat src, Mat mask, Mat dst) {
        
        colorChange_1(src.nativeObj, mask.nativeObj, dst.nativeObj);
        
        return;
    }
    
    
    //
    // C++:  void inpaint(Mat src, Mat inpaintMask, Mat& dst, double inpaintRadius, int flags)
    //
    
    private static native void colorChange_1(long src_nativeObj, long mask_nativeObj, long dst_nativeObj);
    
    
    //
    // C++:  void pencilSketch(Mat src, Mat& dst1, Mat& dst2, float sigma_s = 60, float sigma_r = 0.07f, float shade_factor = 0.02f)
    //
    
    //javadoc: decolor(src, grayscale, color_boost)
    public static void decolor(Mat src, Mat grayscale, Mat color_boost) {
        
        decolor_0(src.nativeObj, grayscale.nativeObj, color_boost.nativeObj);
        
        return;
    }
    
    // C++:  void decolor(Mat src, Mat& grayscale, Mat& color_boost)
    private static native void decolor_0(long src_nativeObj, long grayscale_nativeObj, long color_boost_nativeObj);
    
    
    //
    // C++:  void seamlessClone(Mat src, Mat dst, Mat mask, Point p, Mat& blend, int flags)
    //
    
    //javadoc: denoise_TVL1(observations, result, lambda, niters)
    public static void denoise_TVL1(List<Mat> observations, Mat result, double lambda, int niters) {
        Mat observations_mat = Converters.vector_Mat_to_Mat(observations);
        denoise_TVL1_0(observations_mat.nativeObj, result.nativeObj, lambda, niters);
        
        return;
    }
    
    
    //
    // C++:  void stylization(Mat src, Mat& dst, float sigma_s = 60, float sigma_r = 0.45f)
    //
    
    // C++:  void denoise_TVL1(vector_Mat observations, Mat result, double lambda = 1.0, int niters = 30)
    private static native void denoise_TVL1_0(long observations_mat_nativeObj, long result_nativeObj, double lambda, int niters);
    
    //javadoc: denoise_TVL1(observations, result)
    public static void denoise_TVL1(List<Mat> observations, Mat result) {
        Mat observations_mat = Converters.vector_Mat_to_Mat(observations);
        denoise_TVL1_1(observations_mat.nativeObj, result.nativeObj);
        
        return;
    }
    
    
    //
    // C++:  void textureFlattening(Mat src, Mat mask, Mat& dst, float low_threshold = 30, float high_threshold = 45, int kernel_size = 3)
    //
    
    private static native void denoise_TVL1_1(long observations_mat_nativeObj, long result_nativeObj);
    
    //javadoc: detailEnhance(src, dst, sigma_s, sigma_r)
    public static void detailEnhance(Mat src, Mat dst, float sigma_s, float sigma_r) {
        
        detailEnhance_0(src.nativeObj, dst.nativeObj, sigma_s, sigma_r);
        
        return;
    }
    
    // C++:  void detailEnhance(Mat src, Mat& dst, float sigma_s = 10, float sigma_r = 0.15f)
    private static native void detailEnhance_0(long src_nativeObj, long dst_nativeObj, float sigma_s, float sigma_r);
    
    //javadoc: detailEnhance(src, dst)
    public static void detailEnhance(Mat src, Mat dst) {
        
        detailEnhance_1(src.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void detailEnhance_1(long src_nativeObj, long dst_nativeObj);
    
    //javadoc: edgePreservingFilter(src, dst, flags, sigma_s, sigma_r)
    public static void edgePreservingFilter(Mat src, Mat dst, int flags, float sigma_s, float sigma_r) {
        
        edgePreservingFilter_0(src.nativeObj, dst.nativeObj, flags, sigma_s, sigma_r);
        
        return;
    }
    
    // C++:  void edgePreservingFilter(Mat src, Mat& dst, int flags = 1, float sigma_s = 60, float sigma_r = 0.4f)
    private static native void edgePreservingFilter_0(long src_nativeObj, long dst_nativeObj, int flags, float sigma_s, float sigma_r);
    
    //javadoc: edgePreservingFilter(src, dst)
    public static void edgePreservingFilter(Mat src, Mat dst) {
        
        edgePreservingFilter_1(src.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void edgePreservingFilter_1(long src_nativeObj, long dst_nativeObj);
    
    //javadoc: fastNlMeansDenoising(src, dst, h, templateWindowSize, searchWindowSize)
    public static void fastNlMeansDenoising(Mat src, Mat dst, float h, int templateWindowSize, int searchWindowSize) {
        
        fastNlMeansDenoising_0(src.nativeObj, dst.nativeObj, h, templateWindowSize, searchWindowSize);
        
        return;
    }
    
    // C++:  void fastNlMeansDenoising(Mat src, Mat& dst, float h = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    private static native void fastNlMeansDenoising_0(long src_nativeObj, long dst_nativeObj, float h, int templateWindowSize, int searchWindowSize);
    
    //javadoc: fastNlMeansDenoising(src, dst)
    public static void fastNlMeansDenoising(Mat src, Mat dst) {
        
        fastNlMeansDenoising_1(src.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void fastNlMeansDenoising_1(long src_nativeObj, long dst_nativeObj);
    
    //javadoc: fastNlMeansDenoising(src, dst, h, templateWindowSize, searchWindowSize, normType)
    public static void fastNlMeansDenoising(Mat src, Mat dst, MatOfFloat h, int templateWindowSize, int searchWindowSize, int normType) {
        Mat h_mat = h;
        fastNlMeansDenoising_2(src.nativeObj, dst.nativeObj, h_mat.nativeObj, templateWindowSize, searchWindowSize, normType);
        
        return;
    }
    
    // C++:  void fastNlMeansDenoising(Mat src, Mat& dst, vector_float h, int templateWindowSize = 7, int searchWindowSize = 21, int normType = NORM_L2)
    private static native void fastNlMeansDenoising_2(long src_nativeObj, long dst_nativeObj, long h_mat_nativeObj, int templateWindowSize, int searchWindowSize, int normType);
    
    //javadoc: fastNlMeansDenoising(src, dst, h)
    public static void fastNlMeansDenoising(Mat src, Mat dst, MatOfFloat h) {
        Mat h_mat = h;
        fastNlMeansDenoising_3(src.nativeObj, dst.nativeObj, h_mat.nativeObj);
        
        return;
    }
    
    private static native void fastNlMeansDenoising_3(long src_nativeObj, long dst_nativeObj, long h_mat_nativeObj);
    
    //javadoc: fastNlMeansDenoisingColored(src, dst, h, hColor, templateWindowSize, searchWindowSize)
    public static void fastNlMeansDenoisingColored(Mat src, Mat dst, float h, float hColor, int templateWindowSize, int searchWindowSize) {
        
        fastNlMeansDenoisingColored_0(src.nativeObj, dst.nativeObj, h, hColor, templateWindowSize, searchWindowSize);
        
        return;
    }
    
    // C++:  void fastNlMeansDenoisingColored(Mat src, Mat& dst, float h = 3, float hColor = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    private static native void fastNlMeansDenoisingColored_0(long src_nativeObj, long dst_nativeObj, float h, float hColor, int templateWindowSize, int searchWindowSize);
    
    //javadoc: fastNlMeansDenoisingColored(src, dst)
    public static void fastNlMeansDenoisingColored(Mat src, Mat dst) {
        
        fastNlMeansDenoisingColored_1(src.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void fastNlMeansDenoisingColored_1(long src_nativeObj, long dst_nativeObj);
    
    //javadoc: fastNlMeansDenoisingColoredMulti(srcImgs, dst, imgToDenoiseIndex, temporalWindowSize, h, hColor, templateWindowSize, searchWindowSize)
    public static void fastNlMeansDenoisingColoredMulti(List<Mat> srcImgs, Mat dst, int imgToDenoiseIndex, int temporalWindowSize, float h, float hColor, int templateWindowSize, int searchWindowSize) {
        Mat srcImgs_mat = Converters.vector_Mat_to_Mat(srcImgs);
        fastNlMeansDenoisingColoredMulti_0(srcImgs_mat.nativeObj, dst.nativeObj, imgToDenoiseIndex, temporalWindowSize, h, hColor, templateWindowSize, searchWindowSize);
        
        return;
    }
    
    // C++:  void fastNlMeansDenoisingColoredMulti(vector_Mat srcImgs, Mat& dst, int imgToDenoiseIndex, int temporalWindowSize, float h = 3, float hColor = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    private static native void fastNlMeansDenoisingColoredMulti_0(long srcImgs_mat_nativeObj, long dst_nativeObj, int imgToDenoiseIndex, int temporalWindowSize, float h, float hColor, int templateWindowSize, int searchWindowSize);
    
    //javadoc: fastNlMeansDenoisingColoredMulti(srcImgs, dst, imgToDenoiseIndex, temporalWindowSize)
    public static void fastNlMeansDenoisingColoredMulti(List<Mat> srcImgs, Mat dst, int imgToDenoiseIndex, int temporalWindowSize) {
        Mat srcImgs_mat = Converters.vector_Mat_to_Mat(srcImgs);
        fastNlMeansDenoisingColoredMulti_1(srcImgs_mat.nativeObj, dst.nativeObj, imgToDenoiseIndex, temporalWindowSize);
        
        return;
    }
    
    private static native void fastNlMeansDenoisingColoredMulti_1(long srcImgs_mat_nativeObj, long dst_nativeObj, int imgToDenoiseIndex, int temporalWindowSize);
    
    //javadoc: fastNlMeansDenoisingMulti(srcImgs, dst, imgToDenoiseIndex, temporalWindowSize, h, templateWindowSize, searchWindowSize)
    public static void fastNlMeansDenoisingMulti(List<Mat> srcImgs, Mat dst, int imgToDenoiseIndex, int temporalWindowSize, float h, int templateWindowSize, int searchWindowSize) {
        Mat srcImgs_mat = Converters.vector_Mat_to_Mat(srcImgs);
        fastNlMeansDenoisingMulti_0(srcImgs_mat.nativeObj, dst.nativeObj, imgToDenoiseIndex, temporalWindowSize, h, templateWindowSize, searchWindowSize);
        
        return;
    }
    
    // C++:  void fastNlMeansDenoisingMulti(vector_Mat srcImgs, Mat& dst, int imgToDenoiseIndex, int temporalWindowSize, float h = 3, int templateWindowSize = 7, int searchWindowSize = 21)
    private static native void fastNlMeansDenoisingMulti_0(long srcImgs_mat_nativeObj, long dst_nativeObj, int imgToDenoiseIndex, int temporalWindowSize, float h, int templateWindowSize, int searchWindowSize);
    
    //javadoc: fastNlMeansDenoisingMulti(srcImgs, dst, imgToDenoiseIndex, temporalWindowSize)
    public static void fastNlMeansDenoisingMulti(List<Mat> srcImgs, Mat dst, int imgToDenoiseIndex, int temporalWindowSize) {
        Mat srcImgs_mat = Converters.vector_Mat_to_Mat(srcImgs);
        fastNlMeansDenoisingMulti_1(srcImgs_mat.nativeObj, dst.nativeObj, imgToDenoiseIndex, temporalWindowSize);
        
        return;
    }
    
    private static native void fastNlMeansDenoisingMulti_1(long srcImgs_mat_nativeObj, long dst_nativeObj, int imgToDenoiseIndex, int temporalWindowSize);
    
    //javadoc: fastNlMeansDenoisingMulti(srcImgs, dst, imgToDenoiseIndex, temporalWindowSize, h, templateWindowSize, searchWindowSize, normType)
    public static void fastNlMeansDenoisingMulti(List<Mat> srcImgs, Mat dst, int imgToDenoiseIndex, int temporalWindowSize, MatOfFloat h, int templateWindowSize, int searchWindowSize, int normType) {
        Mat srcImgs_mat = Converters.vector_Mat_to_Mat(srcImgs);
        Mat h_mat = h;
        fastNlMeansDenoisingMulti_2(srcImgs_mat.nativeObj, dst.nativeObj, imgToDenoiseIndex, temporalWindowSize, h_mat.nativeObj, templateWindowSize, searchWindowSize, normType);
        
        return;
    }
    
    // C++:  void fastNlMeansDenoisingMulti(vector_Mat srcImgs, Mat& dst, int imgToDenoiseIndex, int temporalWindowSize, vector_float h, int templateWindowSize = 7, int searchWindowSize = 21, int normType = NORM_L2)
    private static native void fastNlMeansDenoisingMulti_2(long srcImgs_mat_nativeObj, long dst_nativeObj, int imgToDenoiseIndex, int temporalWindowSize, long h_mat_nativeObj, int templateWindowSize, int searchWindowSize, int normType);
    
    //javadoc: fastNlMeansDenoisingMulti(srcImgs, dst, imgToDenoiseIndex, temporalWindowSize, h)
    public static void fastNlMeansDenoisingMulti(List<Mat> srcImgs, Mat dst, int imgToDenoiseIndex, int temporalWindowSize, MatOfFloat h) {
        Mat srcImgs_mat = Converters.vector_Mat_to_Mat(srcImgs);
        Mat h_mat = h;
        fastNlMeansDenoisingMulti_3(srcImgs_mat.nativeObj, dst.nativeObj, imgToDenoiseIndex, temporalWindowSize, h_mat.nativeObj);
        
        return;
    }
    
    private static native void fastNlMeansDenoisingMulti_3(long srcImgs_mat_nativeObj, long dst_nativeObj, int imgToDenoiseIndex, int temporalWindowSize, long h_mat_nativeObj);
    
    //javadoc: illuminationChange(src, mask, dst, alpha, beta)
    public static void illuminationChange(Mat src, Mat mask, Mat dst, float alpha, float beta) {
        
        illuminationChange_0(src.nativeObj, mask.nativeObj, dst.nativeObj, alpha, beta);
        
        return;
    }
    
    // C++:  void illuminationChange(Mat src, Mat mask, Mat& dst, float alpha = 0.2f, float beta = 0.4f)
    private static native void illuminationChange_0(long src_nativeObj, long mask_nativeObj, long dst_nativeObj, float alpha, float beta);
    
    //javadoc: illuminationChange(src, mask, dst)
    public static void illuminationChange(Mat src, Mat mask, Mat dst) {
        
        illuminationChange_1(src.nativeObj, mask.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void illuminationChange_1(long src_nativeObj, long mask_nativeObj, long dst_nativeObj);
    
    //javadoc: inpaint(src, inpaintMask, dst, inpaintRadius, flags)
    public static void inpaint(Mat src, Mat inpaintMask, Mat dst, double inpaintRadius, int flags) {
        
        inpaint_0(src.nativeObj, inpaintMask.nativeObj, dst.nativeObj, inpaintRadius, flags);
        
        return;
    }
    
    // C++:  void inpaint(Mat src, Mat inpaintMask, Mat& dst, double inpaintRadius, int flags)
    private static native void inpaint_0(long src_nativeObj, long inpaintMask_nativeObj, long dst_nativeObj, double inpaintRadius, int flags);
    
    //javadoc: pencilSketch(src, dst1, dst2, sigma_s, sigma_r, shade_factor)
    public static void pencilSketch(Mat src, Mat dst1, Mat dst2, float sigma_s, float sigma_r, float shade_factor) {
        
        pencilSketch_0(src.nativeObj, dst1.nativeObj, dst2.nativeObj, sigma_s, sigma_r, shade_factor);
        
        return;
    }
    
    // C++:  void pencilSketch(Mat src, Mat& dst1, Mat& dst2, float sigma_s = 60, float sigma_r = 0.07f, float shade_factor = 0.02f)
    private static native void pencilSketch_0(long src_nativeObj, long dst1_nativeObj, long dst2_nativeObj, float sigma_s, float sigma_r, float shade_factor);
    
    //javadoc: pencilSketch(src, dst1, dst2)
    public static void pencilSketch(Mat src, Mat dst1, Mat dst2) {
        
        pencilSketch_1(src.nativeObj, dst1.nativeObj, dst2.nativeObj);
        
        return;
    }
    
    private static native void pencilSketch_1(long src_nativeObj, long dst1_nativeObj, long dst2_nativeObj);
    
    //javadoc: seamlessClone(src, dst, mask, p, blend, flags)
    public static void seamlessClone(Mat src, Mat dst, Mat mask, Point p, Mat blend, int flags) {
        
        seamlessClone_0(src.nativeObj, dst.nativeObj, mask.nativeObj, p.x, p.y, blend.nativeObj, flags);
        
        return;
    }
    
    // C++:  void seamlessClone(Mat src, Mat dst, Mat mask, Point p, Mat& blend, int flags)
    private static native void seamlessClone_0(long src_nativeObj, long dst_nativeObj, long mask_nativeObj, double p_x, double p_y, long blend_nativeObj, int flags);
    
    //javadoc: stylization(src, dst, sigma_s, sigma_r)
    public static void stylization(Mat src, Mat dst, float sigma_s, float sigma_r) {
        
        stylization_0(src.nativeObj, dst.nativeObj, sigma_s, sigma_r);
        
        return;
    }
    
    // C++:  void stylization(Mat src, Mat& dst, float sigma_s = 60, float sigma_r = 0.45f)
    private static native void stylization_0(long src_nativeObj, long dst_nativeObj, float sigma_s, float sigma_r);
    
    //javadoc: stylization(src, dst)
    public static void stylization(Mat src, Mat dst) {
        
        stylization_1(src.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void stylization_1(long src_nativeObj, long dst_nativeObj);
    
    //javadoc: textureFlattening(src, mask, dst, low_threshold, high_threshold, kernel_size)
    public static void textureFlattening(Mat src, Mat mask, Mat dst, float low_threshold, float high_threshold, int kernel_size) {
        
        textureFlattening_0(src.nativeObj, mask.nativeObj, dst.nativeObj, low_threshold, high_threshold, kernel_size);
        
        return;
    }
    
    // C++:  void textureFlattening(Mat src, Mat mask, Mat& dst, float low_threshold = 30, float high_threshold = 45, int kernel_size = 3)
    private static native void textureFlattening_0(long src_nativeObj, long mask_nativeObj, long dst_nativeObj, float low_threshold, float high_threshold, int kernel_size);
    
    //javadoc: textureFlattening(src, mask, dst)
    public static void textureFlattening(Mat src, Mat mask, Mat dst) {
        
        textureFlattening_1(src.nativeObj, mask.nativeObj, dst.nativeObj);
        
        return;
    }
    
    private static native void textureFlattening_1(long src_nativeObj, long mask_nativeObj, long dst_nativeObj);
    
}
