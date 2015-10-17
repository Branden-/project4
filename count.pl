#!/usr/bin/perl
my $startTime = time();
while (<>) {
  s/[.,;!?*+-=\\|#\/(){}"'[\]><]/ /g;
  @line = split;
  for $i (@line) {
    $i = lc $i;
    if (defined $words{$i}) {
      $words{$i}++;
    } else {
      $words{$i} = 1;
    }
  }
}


for $w (sort {$f = $words{$a} <=> $words{$b};
	      $f != 0 ? -$f : ($a cmp $b)}
	keys %words) {
  print "$words{$w} \t$w\n";
}

my $endrun = time();
my $runTime = $endrun - $startTime;
print "Tokenizing, sorting and printing took $runTime seconds \n";
