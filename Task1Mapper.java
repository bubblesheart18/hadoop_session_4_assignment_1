package mapreduce.demo.task1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task1Mapper extends Mapper<LongWritable, Text, Text, Text> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("\\|");
		System.out.println();
		if(!("NA".equalsIgnoreCase(lineArray[0])) &&!("NA".equalsIgnoreCase(lineArray[1])))
		{
			Text company = new Text(lineArray[0]);
			Text state = new Text(lineArray[3]);
			context.write(company, state);
		}
	}
}
