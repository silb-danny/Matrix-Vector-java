package mathExt;

public class Mapping {

    public static int[] triangles(int w, int h) {
        int tringle = (w-1) * (h-1) * 6;
        int[] tringles = new int[tringle];
        int pos = 0;
        int dir = 1;

        for (int i = 0; i < tringle; i++) {
            tringles[i] = pos; i++; pos += dir*(w+1);
            tringles[i] = pos; i++; pos -= dir;
            tringles[i] = pos;
            pos += ((pos+1)%w==0)?1:(1+dir)/2;
            dir *= -1;
        }
        return tringles;
    }
}
