my @total_reward;
$root = "/home/shiwali/infiniteMario/agents/sample_marioAgentJava/data";


for ($count = 1; $count <= 5; $count++){
    $filename = "$root$count";
    print "processing file $filename \n";
    open FILE, $filename or die $!;
    my $i=0;
    while (<FILE>){
	my @split_data = split(' ',$_);
	$total_reward[$i] = $total_reward[$i] + $split_data[0];
	$i=$i+1;
    }
}

for ($j = 0; $j < 1500; $j++){
    $divide = $total_reward[$j]/5;
   print "$divide\n";
}
