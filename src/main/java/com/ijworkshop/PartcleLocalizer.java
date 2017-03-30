/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package com.ijworkshop;

import ij.IJ;
import ij.ImagePlus;
import ij.measure.CurveFitter;
import ij.plugin.PlugIn;
import ij.process.ImageProcessor;

public class PartcleLocalizer implements PlugIn {

	@Override
	public void run(String arg) {
		ImagePlus imp = IJ.getImage();
		ImageProcessor ip = imp.getProcessor();
		double[] xData = new double[11];
		double[] yData = new double[11];
		int count = 0;
		for (int i = 123; i <= 133; i++) {
			xData[count] = i;
			for (int j = 123; j <= 133; j++) {
				int value = ip.get(i, j);
				yData[count] += value;
			}
			count++;
		}
		CurveFitter fitter = new CurveFitter(xData, yData);
		fitter.doFit(CurveFitter.GAUSSIAN);
		IJ.log("mean: " + fitter.getParams()[2]);
	}
	
}
