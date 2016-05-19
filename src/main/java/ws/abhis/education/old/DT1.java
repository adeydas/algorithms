package ws.abhis.education.old;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * DT1
 */
public class DT1 extends TestCase {

    public String keyCount(File inputFile) throws IOException {
        //Throw error if file does not exist
        if (!inputFile.exists())
            throw new IOException("Input file not found");

        StringBuffer result = new StringBuffer(); //store the final result
        Map<String, Integer> intMap = new HashMap<>(); //intermediate map to store values

        //Open file to read line by line
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line = "";
        while ((line=br.readLine()) != null) {
            if (line.contains(",")) {
                //if the line contains a ',', separate
                line = line.replaceAll("\\s",""); //remove white spaces
                String[] t = line.split(",");
                try {
                    int count = Integer.parseInt(t[1]);
                    /**
                     * If the map contains the key, increment the value with the prevVal+newVal
                     * else create a new entry
                     */
                    if (intMap.containsKey(t[0])) {
                        int countNow = intMap.get(t[0]);
                        countNow += count;
                        intMap.put(t[0], countNow);
                    } else {
                        intMap.put(t[0], count);
                    }
                } catch (NumberFormatException npe) {
                    continue;
                }
            }
        }

        //Read the map and create output
        Iterator it = intMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) it.next();
            String key = entry.getKey();
            int val = entry.getValue();

            result.append("The total for " + key + " is " + Integer.toString(val) + ". ");
        }
        String ret = result.toString();
        ret = ret.substring(0, ret.length()-1); //remove the extra space at the end

        return ret;
    }

    public void testOne() throws IOException {
        File f = new File("dt1input.txt");
        assertTrue(keyCount(f).equals("The total for John is 6. The total for Jane is 8."));
    }
}
