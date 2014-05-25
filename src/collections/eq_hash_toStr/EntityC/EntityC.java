package collections.eq_hash_toStr.EntityC;

import collections.eq_hash_toStr.EntityA.EntityA;
import collections.eq_hash_toStr.EntityB.EntityB;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;

    public EntityC(EntityA entity, List<EntityB> list, Map<Set<EntityA>, List<EntityB[]>> map) {
        this.entity = entity;
        this.list = list;
        this.map = map;
    }

    public EntityA getEntity() {
        return entity;
    }

    public List<EntityB> getList() {
        return list;
    }

    public Map<Set<EntityA>, List<EntityB[]>> getMap() {
        return map;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = entity.hashCode();
        for( EntityB entityB : list ){
            result = result * prime + entityB.hashCode();
        }

        Iterator<Set<EntityA>> keysIterator = map.keySet().iterator();
        while(keysIterator.hasNext()){
             Iterator<EntityA> setEntityAIterator = keysIterator.next().iterator();
            while (setEntityAIterator.hasNext()){
                result = result * prime + setEntityAIterator.next().hashCode();
            }
        }

        Iterator<List<EntityB[]>> valueIterator = map.values().iterator();
        while (valueIterator.hasNext()){
            List<EntityB[]> listEntityBArrays = valueIterator.next();
            //TODO: Hash Code all entity.
        }

        return (entity.hashCode()*31 + list.hashCode())*31 + map.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "[entity"+entity.toString()+ list.toString()+map.toString()+"}";
    }
}