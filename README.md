# COMP6521_LA2

### Description
This is the second lab project of course COMP6521. The purpose is to merge and deduplicate two files with the same format using Bitmap indexes and analyze the time and io number of the process. The line number of files is about 10,000 and 5,000. They need to be put in the file `/src/Data_Files`.

### Configuration
1. Language: Java
2. Method: Bitmap index
3. Test Framework: JUnit4

### Implementation
1. Generate three Bitmap indexes based on EmpID, Gender, and Dept information.
2. Compress three Bitmap indexes to generate three compressed files.
3. According to the information of the EmpID Bitmap index, find the corresponding lines in the original file and output them to a new file. This process can achieve sorting and deduplication.
4. Merge two files to get the final output file. This process can achieve deduplicating again.

### Reference
[Bitmap index](https://en.wikipedia.org/wiki/Bitmap_index)

