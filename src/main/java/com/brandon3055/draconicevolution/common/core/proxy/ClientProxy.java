package draconicevolution.common.core.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import draconicevolution.client.render.BowRenderer;
import draconicevolution.client.render.ItemParticleGenRenderer;
import draconicevolution.client.render.ParticleGenRenderer;
import draconicevolution.DraconicEvolution;
import draconicevolution.common.blocks.ModBlocks;
import draconicevolution.common.items.ModItems;
import draconicevolution.common.tileentities.TileParticleGenerator;

public class ClientProxy extends CommonProxy {
	private final static boolean debug = DraconicEvolution.debug;
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{if(debug)
		System.out.println("on Client side");
		super.preInit(event);
		
		//Client Only
		registerRendering();
	}

	@Override
	public void init(FMLInitializationEvent event)
	{if(debug)
		System.out.println("on Client side");
		super.init(event);

		//Client Only
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{if(debug)
		System.out.println("on Client side");
		super.postInit(event);
		
		//Client Only
	}

	public void registerRendering()
	{
		MinecraftForgeClient.registerItemRenderer(ModItems.wyvernBow, new BowRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.draconicBow, new BowRenderer());
		
		TileEntitySpecialRenderer render = new ParticleGenRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileParticleGenerator.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.particleGenerator), new ItemParticleGenRenderer(render, new TileParticleGenerator()));
        
	}
}