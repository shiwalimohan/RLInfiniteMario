my @combined;
$file1 = "data.dat";
$file2 = "mov_av_sample.data";
open FILE1, $file1 or die $!;
open FILE2, $file2 or die $!;

my @data1;
my $i=0;
while (<FILE1>){
    chomp($_);
    @data1[$i] = $_;
      $i=$i+1;
 }

my @data2;
$i=0;
while (<FILE2>){
    chomp($_);
    @data2[$i] = $_;
      $i=$i+1;
}

for ($count = 1; $count <= 1500; $count++){
    print "$count @data1[$count] @data2[$count]\n";
}
