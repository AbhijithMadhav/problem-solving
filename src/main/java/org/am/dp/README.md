# LIS

## formulation

LIS<sub>i</sub> = Max<sub>k = i + 1 to n </sub> LIS<sub>k </sub> + 1 iff nums[k] > nums[i]
indeterminate otherwise

LIS = Max<sub> i = 0 to n </sub> LIS<sub>i</sub> 