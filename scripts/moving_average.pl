$filename = "sample_agent.data";
open new_file, $filename or die $!;
my @data;
my $i=0;
while (<new_file>){
    @data[$i] = $_;
      $i=$i+1;
}
print @data;
for ($count=0; $count < 1500-10; $count++){
    my $sum = 0;
    for ($k = $count; $k < $count+10; $k++){
	$sum = $sum + @data[$k];
    }
    my $divide = $sum/10;
    print "$divide \n";
}
