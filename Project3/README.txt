Included in the `src` folder is a file called Project3.java. This is our
own tester file for the project. At the end of this file is way to run
the project as if you are running from the commandline and will save
you time if you prefer not to use the commandline. Otherwise we implemented
the WordCount.java and Correlator.java which can be run from the commandline
as requested in the project.

Below you will find the questions from the assignment along with our answers.
If more info is needed, or you need help running our project you can contact
us directly:

Branden Andersen
email: branden.andersen@sjsu.edu
Mobile: 650 943-3999

Anh Ho
email: anhqpho@gmail.com


1.  Who is in your group?

    Anh Ho and Branden Andersen

2.  How long did the project take?

    The project took approximately thirty hours to complete. Anh put in about
17 hours and Branden put in the other thirteen hours.

3.  Before you started, which data structure did you expect would be the
    fastest?

    We both expected the hash table to be the fastest data structure because of
how it is basically an array using keys.

4.  Which data structure is the fastest? Why were you right or wrong?

    The hash table was the fastest data structure and therefore we were right
in our expectations.

5.  In general, which DataCounter dictionary implementation was "better":
    trees or hash tables? Note that you will need to define "better" (
    ease of coding, ease of debugging, memory usage, disk access patterns,
    runtime for average input, runtime for all input, etc).

    Before explaining which DataCounter dictionary implementation was better,
we will define what we mean by better. The primary objective metric we measured
was execution time and memory usage. Memory usage was determined by using a
plugin called Memory Analyzer, which took a dump file and displayed in pie
chart how much memory was being used and by what object. Execution time was
measured using the method System.nanoTime() and was measured from when the
objects were created to the end where all the data was printed. Our subjective
metric was how easily each data structure on scale of 1 to 10, where 1 is the
easiest data structure to code (better) and 10 is the hardest data structure to
code (worse). Our assumption was that there is no hard disk access, and all
items are in memory.

    With respect to memory usage, the hash table used slight more memory on
average. The memory usage for a binary search tree and an AVL tree was
basically the same. When memory usage is considered for a standard PC, the
difference in memory usage is negligible. If memory usage is a major
restriction such as on a micro controller, a binary search tree or AVL tree
implementation would be a a better data structure.

    When considering execution time, a hash table is hands down the fastest
data structure. Our timing was measured in seconds, and even with large files a
hash table was able to perform the operations in less than a second. The next
fastest data structure was the binary search tree (usually on the order of
three to five sceonds). The slowest data structure by several hundreds of
seconds (on the order of minutes slower) was the AVL tree. If execution time is
the primary concern, the best data structure to use would be a hash table.

    As for coding difficulty, the data structure that got the highest rating
for being the most difficult to code is the AVL tree (score of 10). The
rotations and the updating of the node heights were the most difficult to code.
The easiest to code was the binary search tree (score of 1) since it was
relatively easy to conceptualize and most of the coding could be solved with
very simple recursion. The hash table data structure got a score of 5 for
coding difficulty. Figuring out what hash to use and implementing the linked
list for collision were the most difficult aspects of the coding but  were
still far easier to code than the rotations of the AVL tree.

   Considering the previous ratings, the better DataCounter dictionary
implementation was the hash table. The hash table is relatively easy to code,
runs very fast, and its memory usage is not much more on average than the
binary tree or the AVL tree.

6.  Are there cases in which a particular data structure performs really
    well or badly in the correlator? Enumerate the cases for each data
    structure.

    For very large amounts of data, the AVL tree performed very badly compared
with any of the other data structures. The hash table performed consistently
well with regards to speed for large or small data sets. The binary search tree
data structure was fast but never as fast as the hash table, and began to take
couples of seconds when running very large data sets are opposed to less than a
second for a hash table.

7.  Give a one or two paragraph explanation of whether or not you think
    Bacon wrote Shakespeare's plays based on the data you collected. No
    fancy statistical analysis here (formal analysis comes later); keep
    it fun and simple.

    When examining the different works of Shakespeare against other works of
Shakespeare, the Euclidean frequency distance is zero. When examining the
complete works of Shakespeare against Bacon's works, the Euclidean frequency
distance is 0.0349. From this we can conclude that Shakespeare was the actual
author of the` works attributed to him and not Francis Bacon.


8.  Writeup your benchmarks (this is long). Your mission is to convince
    us that your benchmark makes sense and that we should be interested
    in it if we are trying to ascertain which data structure is better
    suited for your input. You will need to answer at least the following
    (all formal analysis should answer something similar):
    * What are you measuring?
    * What is the definition of "better" given your measurement?
    * Why is the measurement interesting in determining which is the
      superior algorithm for this project?
    * What was your method of benchmarking?
    * What were the sources of errors?
    * What were your results?
    * How did you interpret your results?
    * What were your conclusions?
    * Are there any interesting directions for future study?

    For the bench marks we were primarily interested in two things, speed of
execution (how much time did it take to execute the code with a particular data
structure) and how much memory was used by the application for each particular
data structure. To measure the time for execution in the java code, a start
time variable was created and  assigned a value from System.nanoTime(). The end
time was recorded using the same method at the end of printing the output as
required by the assignment. We chose to record the time after printing the
output because we were running our comparison against Perl script as well which
was similarly timed before and after the tokenizing, sorting, and printing of
the output was done. So in our timing there was some overhead due to the
printing to the command window.  For analyzing the memory used we used a plugin
called the Eclipse Memory Analyzer. Our first step to use the plugin was to add
a commandline argument to the JVM which made the JVM output a heap memory dump.
The commandline used was: `-agentlib:hprof=heap=dump,format=b`. The dump file
(file extension .hprof) was then opened inside eclipse and the plugin did its
job analyzing the memory dump and putting it into a pie chart. We then compared
the memory dump of all the different data structures implemented in the
assignment.

    In terms of better, for both measurements smaller was always better.  If
the data structure used less memory, then it was better for memory.  If the
data structure took less time to execute than the other data structures than it
was better.

    These measurements are interesting because typically in computer science we
are concerned with efficiency, that is "does it run fast with as few resources
as possible." If something runs fast and uses little memory (or uses less
memory compared to other methods), then that program or data structure is
desirable since it will probably solve the problem we are trying to solve much
faster. Therefore we measured memory usage and execution time as our metrics.
It should be noted that coding difficulty can also be a consideration, and was
discussed earlier. For this part of the analysis we will only be concerned with
the hard metrics of time and memory usage.

    For bench marking the execution time, we recorded the time it took to
execute the DataCounter dictionary plus the time it took to print the two lists
with their frequency. The Perl script did slightly less work as it only
analyzed one document, but it was timed for analysis plus the time it took for
it to print all the frequencies of the words. Therefore we would expect the
Perl script to be much more faster or at least slightly faster than our java
code.

    For the memory usage, we created a memory dump file at the end of program
execution and used Eclipse Memory analyzer plugin to view the results of the
dump file. We did not do a memory analysis of the Perl script.

    Our main source of error in the execution time benchmark is the fact we
also timed the printing of the dictionary with the frequencies but since we did
this with everything we benchmarked this extra execution time will cancel out
when we compare it against the different data structures. We also did some
timing of just the printing of the dictionary with frequencies and it took
approximately 11 seconds in the case we will be discussing in the next
paragraph. Another source of error in timing the execution time is we converted
nano seconds to seconds in Java and only measured seconds when we ran the Perl
script so there is some quantization error. To makes for this error, we ran
very large files (the complete works of Shakespeare) so that any delay in
execution would be able to be measured on the order of seconds and not milli or
nano seconds. For the memory measurement, again we were measuring all the
measuring used by the program program not just the memory used by the data
structures. The extra memory used should be controlled for by the fact we used
the same files and therefore the difference in measurement should be solely
because of the efficiency of the data structure.

    For the all bench marking of the java program, we used two files in the
same directory as this README.txt file. We analyzed the file
completeWorksofShakespeare.txt (file 1) and EssayOfSirFrancisBacon.txt (file
2). The results are shown in table 1.

    Table 1. Results from execution time bench mark.
    -----------------------------------------------------------
    | Name of Data Strucutre |  time (file 1) | time (file 2) |
    |                        |  [seconds]     | [seconds]     |
    |------------------------|----------------|---------------|
    |  Hash Table            |       12       |       11      |
    |------------------------|----------------|---------------|
    |  Binary Search Tree    |       12       |       11      |
    |------------------------|----------------|---------------|
    |  AVL Tree              |       370      |       11      |
    |------------------------|----------------|---------------|
    |  Perl Script*          |       12       |       N/A     |
    -----------------------------------------------------------
    *NOTE: Perl script only examined one large file

    For the memory analysis, we were mainly concerned with just the data
structures we implemented therefore we did not analyze the memory usage of the
Perl Scipt. Average memory usage based on using the same two files used for the
execution time bench mark. Results can be seen in table 2.

    Table 2. Results from the memory usage bench mark.
    -------------------------------------------
    | Name of Data Strucutre |  Memory Used   |
    |                        |  [kiloBytes]   |
    |------------------------|----------------|
    |  Hash Table            |       229.9    |
    |------------------------|----------------|
    |  Binary Search Tree    |       228.8    |
    |------------------------|----------------|
    |  AVL Tree              |       229.6    |
    -------------------------------------------

    From our results we interpret that in almost all respects the best data
structure to implement when both execution time and memory usage is considered
is a hash table. The Perl script ran as fast as the fastest data structures but
had less to analyze and less to print there we can probably conclude the Perl
script is fast not as fast as running something in Jave.

    The hash table data structure did use more memory than the other data
structures, but the memory difference was measure in kilobytes and considering
most modern programs are measured in megabytes or even gigabytes of memory we
can consider the difference in memory usage as negligible. If the device that
will be primarily running the code is a microcontroller, then this memory
difference might be a concern.

    So again we conclude that for most programming purposes, the best data
structure to use for quick access is a hash table. If it is desired that the
data structure sort the data while also holding the data, then a Binary search
tree or an AVL tree would be the suggested data structure.

    For future research it may be interesting to use a binary search tree
instead of a linked list for collisions with a hashtable.

9.  What did you enjoy about this assignment? What did you hate? Could we
    have done anything better?

    We enjoyed programming the project and learning a little more about how to
do some command line stuff. The write up, although necessary for reflecting and
learning, was a bit tidious.

    For the future, it is suggested that some tutorial files or pdf's are given
on how to use the command line, coding in Perl, and Bash scripts.  Implementing
a timing function for us in the Perl and Bash scripts would have been very
helpful.
