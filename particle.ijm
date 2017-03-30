// Create a new image
newImage("particle", "16-bit black", 256, 256, 1);
// Add camera baseline
run("Add...", "value=100");
// Add dark current noise
run("Add Specified Noise...", "standard=5");
// Create a particle (gaussian distribution)
peakIntensity = 1000;
sigma = 2;
for (i = 123; i <= 133; i++) {
	factorX = exp(-1 * (i - 128) * (i - 128) / (2 * sigma * sigma));
	for (j = 123; j <= 133; j++) {
		factorY = exp(-1 * (j - 128) * (j - 128) / (2 * sigma * sigma));
		value = getPixel(i, j);
		value += peakIntensity * factorX * factorY;
		setPixel(i, j, value);
	}
}
resetMinAndMax();