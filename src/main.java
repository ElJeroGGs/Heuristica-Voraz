import control.control_principal;
import modelo.ciudad;
import modelo.heuristicavoraz;
import vista.Interfaz_Principal;

public class main {

    public static void main(String[] args) throws Exception {

int[] ciudadDeMexico = {0, 461, 1543, 2294, 467, 704, 1245, 1007, 358, 427, 1608, 693, 2188, 1039, 297};
int[] guadalajara = {461, 0, 1259, 1884, 7, 636, 997, 335, 295, 172, 1210, 512, 1789, 619, 560};
int[] ciudadJuarez = {1543, 1259, 0, 997, 1253, 893, 335, 2050, 1187, 1126, 1862, 520, 873, 768, 1773};
int[] tijuana = {2294, 1884, 997, 0, 1878, 1785, 935, 2991, 1951, 1868, 2353, 1232, 856, 1266, 2444};
int[] zapopan = {467, 7, 1253, 1878, 0, 634, 924, 297, 296, 139, 1431, 573, 1782, 612, 567};
int[] monterrey = {704, 636, 893, 1785, 634, 0, 660, 1210, 887, 844, 478, 613, 1588, 712, 981};
int[] chihuahua = {1245, 997, 335, 935, 924, 660, 0, 1866, 1181, 1129, 2074, 1263, 805, 1266, 1458};
int[] merida = {1007, 335, 2050, 2991, 297, 1210, 1866, 0, 887, 844, 478, 613, 1588, 712, 981};
int[] sanLuisPotosi = {358, 295, 1187, 1951, 296, 887, 1181, 887, 0, 139, 1231, 139, 1236, 718, 600};
int[] aguascalientes = {427, 172, 1126, 1868, 139, 844, 1129, 844, 139, 0, 1462, 760, 982, 718, 613};
int[] hermosillo = {1608, 1210, 1862, 2353, 1431, 478, 2074, 478, 1231, 1462, 0, 1658, 1058, 1236, 1763};
int[] saltillo = {693, 512, 520, 1232, 573, 613, 1263, 613, 139, 760, 1658, 0, 1206, 594, 1769};
int[] mexicali = {2188, 1789, 873, 856, 1782, 1588, 805, 1588, 1236, 982, 1058, 1206, 0, 648, 2349};
int[] culiacan = {1039, 619, 768, 1266, 612, 712, 1266, 712, 718, 718, 1236, 594, 648, 0, 1179};
int[] acapulcoDeJuarez = {297, 560, 1773, 2444, 567, 981, 1458, 981, 600, 613, 1763, 1769, 2349, 1179, 0};

String[] vecinos = {"Ciudad de México","Guadalajara", "Ciudad Juarez", "Tijuana", "Zapopan", "Monterrey", "Chihuahua", "Merida", "San Luis Potosi", "Aguascalientes", "Hermosillo", "Saltillo", "Mexicali", "Culiacan", "Acapulco de Juarez"};
        
ciudad CDMX = new ciudad("Ciudad de México", vecinos, ciudadDeMexico, 0, new int[]{399, 352});
ciudad GDL = new ciudad("Guadalajara", vecinos, guadalajara, 1, new int[]{396, 327});
ciudad CJ = new ciudad("Ciudad Juarez", vecinos, ciudadJuarez, 2, new int[]{249, 120});
ciudad TJ = new ciudad("Tijuana", vecinos, tijuana, 3, new int[]{58, 68});
ciudad ZP = new ciudad("Zapopan", vecinos, zapopan, 4, new int[]{325, 306});
ciudad MTY = new ciudad("Monterrey", vecinos, monterrey, 5, new int[]{389, 207});
ciudad CH = new ciudad("Chihuahua", vecinos, chihuahua, 6, new int[]{256, 107});
ciudad MD = new ciudad("Merida", vecinos, merida, 7, new int[]{631, 304});
ciudad SLP = new ciudad("San Luis Potosi", vecinos, sanLuisPotosi, 8, new int[]{375, 277});
ciudad AGS = new ciudad("Aguascalientes", vecinos, aguascalientes, 9, new int[]{328, 286});
ciudad HMO = new ciudad("Hermosillo", vecinos, hermosillo, 10, new int[]{154, 104});
ciudad SL = new ciudad("Saltillo", vecinos, saltillo, 11, new int[]{333, 163});
ciudad MXL = new ciudad("Mexicali", vecinos, mexicali, 12, new int[]{39, 20});
ciudad CL = new ciudad("Culiacan", vecinos, culiacan, 13, new int[]{199, 197});
ciudad AC = new ciudad("Acapulco de Juarez", vecinos, acapulcoDeJuarez, 14, new int[]{386, 396});

int[][] distancias = {ciudadDeMexico, guadalajara, ciudadJuarez, tijuana, zapopan, monterrey, chihuahua, merida, sanLuisPotosi, aguascalientes, hermosillo, saltillo, mexicali, culiacan, acapulcoDeJuarez};




heuristicavoraz heuristica = new heuristicavoraz(new ciudad[]{CDMX, GDL, CJ, TJ, ZP, MTY, CH, MD, SLP, AGS, HMO, SL, MXL, CL, AC}, distancias);
Interfaz_Principal interfaz = new Interfaz_Principal();

control_principal control = new control_principal(heuristica, new ciudad[]{CDMX, GDL, CJ, TJ, ZP, MTY, CH, MD, SLP, AGS, HMO, SL, MXL, CL, AC}, interfaz);

control.iniciar();

}

}
