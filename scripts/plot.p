# Gnuplot script file for plotting data

 set xlabel "Runs"
   set xrange [0:1480]
 set ylabel "Total Reward"
   set yrange [-10:110]
 set grid
   plot "final.data" using 1:2 title 'Soar-Modular-RL' with lines linewidth 4 lt 3, "final.data" using 1:3 title 'Sample_Agent' with lines linewidth 4 lt 37
