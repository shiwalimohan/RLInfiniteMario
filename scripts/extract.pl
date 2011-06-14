my @total_reward;
$root = "/home/shiwali/infiniteMario/agents/marioAgentJava/agents/mario-soar-multi/run";


for ($count = 11; $count <= 16; $count++){
    $filename = "$root$count.csv";
    print "processing file $filename \n";
    open FILE, $filename or die $!;
    my $i=0;
    while (<FILE>){
	my @split_data = split(' ',$_);
	$total_reward[$i] = $total_reward[$i] + $split_data[1];
	$i=$i+1;
    }
}

for ($j = 0; $j < 1500; $j++){
    $divide = $total_reward[$j]/6;
   print "$divide\n";
}
