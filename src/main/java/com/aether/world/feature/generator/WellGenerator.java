package com.aether.world.feature.generator;

// TODO: Stubbed. Pending 1.17 rewrite.
public class WellGenerator {
//    private static final Identifier WELL = Aether.locate("well_top");
//
//    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces) {
//        pieces.add(new WellPiece(manager, pos, WELL, rotation));
//    }
//
//    public static class WellPiece extends SimpleStructurePiece {
//        private final BlockRotation rotation;
//        private final Identifier template;
//
//        public WellPiece(StructureManager structureManager, NbtCompound compoundTag) {
//            super(AetherFeatures.WELL_PIECE, compoundTag);
//            this.template = new Identifier(compoundTag.getString("Template"));
//            this.rotation = BlockRotation.valueOf(compoundTag.getString("Rot"));
//            this.initializeStructureData(structureManager);
//        }
//
//        public WellPiece(StructureManager structureManager, BlockPos pos, Identifier template, BlockRotation rotation) {
//            super(AetherFeatures.WELL_PIECE, 0);
//            this.pos = pos;
//            this.rotation = rotation;
//            this.template = template;
//
//            this.initializeStructureData(structureManager);
//        }
//
//        private void initializeStructureData(StructureManager structureManager) {
//            Structure structure = structureManager.getStructureOrBlank(this.template);
//            StructurePlacementData placementData = (new StructurePlacementData())
//                    .setRotation(this.rotation)
//                    .setMirror(BlockMirror.NONE)
//                    .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
//            this.setStructureData(structure, this.pos, placementData);
//        }
//
//        protected void writeNbt(ServerWorld world, NbtCompound tag) {
//            super.writeNbt(world, tag);
//            tag.putString("Template", this.template.toString());
//            tag.putString("Rot", this.rotation.name());
//        }
//
//        @Override
//        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess serverWorldAccess, Random random,
//                                      BlockBox boundingBox) {
//        }
//    }
}
