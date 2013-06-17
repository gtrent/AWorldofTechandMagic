package ly.biz.gtrent.gbw;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import ly.biz.gtrent.gbw.GtrentsBigWorld;
public class WorldGenHandle implements IWorldGenerator { //Implements IWorldGenerator
@Override
public void generate(Random random, int chunkX, int chunkZ, World world, //This is the base generate method
IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

if (world.provider.isSurfaceWorld()){

generateSurface(random,chunkX*16,chunkZ*16,world); //This makes it gen overworld (the *16 is important)

}

}

public void generateSurface(Random random, int x, int z, World w){
for(int i = 0;i<4;i++){ //This goes through the ore metadata
for(int ii=0;ii<20;ii++){ //This makes it gen multiple times in each chunk
int posX = x + random.nextInt(16); //X coordinate to gen at
int posY = random.nextInt(40); //Y coordinate less than 40 to gen at
int posZ = z + random.nextInt(16); //Z coordinate to gen at
new WorldGenMinable(GtrentsBigWorld.topazblock.blockID,i,random.nextInt(9)).generate(w, random, posX, posY, posZ); //The gen call
}
}
}
}