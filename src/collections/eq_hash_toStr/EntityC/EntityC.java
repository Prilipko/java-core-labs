package collections.eq_hash_toStr.EntityC;

import collections.eq_hash_toStr.EntityA.EntityA;
import collections.eq_hash_toStr.EntityB.EntityB;

import java.util.*;

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
        int result = 1;
        result = result * prime + (entity == null ? 0 : entity.hashCode());
        result = result * prime + (list == null ? 0 : list.hashCode());

        if (map != null) {
            for (Map.Entry<Set<EntityA>, List<EntityB[]>> entry : map.entrySet()) {
                result = result * prime + entry.getKey().hashCode();
                for (EntityB[] valueArray : entry.getValue()) {
                    result = result * prime + Arrays.hashCode(valueArray);
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        try {
            EntityC that = (EntityC) obj;
            if (!entity.equals(that.entity)) {
                return false;
            }
            if (!list.equals(that.list)) {
                return false;
            }

            if (that.getMap().size() != map.size()) {
                return false;
            }
            for (Map.Entry<Set<EntityA>, List<EntityB[]>> e : map.entrySet()) {
                Set<EntityA> key = e.getKey();
                List<EntityB[]> value = e.getValue();
                if (value == null) {
                    if (!(that.getMap().get(key) == null && that.getMap().containsKey(key)))
                        return false;
                } else {
                    List<EntityB[]> thatList = that.getMap().get(key);
                    List<EntityB[]> thisList = map.get(key);

                    ListIterator<EntityB[]> e1 = thisList.listIterator();
                    ListIterator<EntityB[]> e2 = thatList.listIterator();
                    while (e1.hasNext() && e2.hasNext()) {
                        EntityB[] o1 = e1.next();
                        EntityB[] o2 = e2.next();
                        if (o1 == null && o2 == null) {
                            continue;
                        }
                        if (o1 == null ^ o2 == null) {
                            return false;
                        }
                        if (!Arrays.equals(o1, o2)) {
                            return false;
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("EntityC{");
        builder.append("entity=");
        builder.append(entity);
        builder.append(", list=");
        builder.append(list);
        builder.append(", map=");

        Iterator<Map.Entry<Set<EntityA>, List<EntityB[]>>> i = map.entrySet().iterator();
        if (! i.hasNext()){
            builder.append("{}");
        } else{
        builder.append('{');
        for (;;) {
            Map.Entry<Set<EntityA>, List<EntityB[]>> e = i.next();
            Set<EntityA> key = e.getKey();
            List<EntityB[]> value = e.getValue();
            builder.append(key   == this ? "(this Map)" : key);
            builder.append('=');

            if(value == this){
                builder.append("(this Map)");
            }else{
                Iterator<EntityB[]> it = value.iterator();
                if (! it.hasNext()){
                    builder.append("[]");
                } else{
                    builder.append('[');
                for (;;) {
                    EntityB[] arr = it.next();
                    builder.append(Arrays.toString(arr));
                    if (! it.hasNext()){
                        builder.append(']');
                        break;
                    }
                    builder.append(',').append(' ');
                }
                }
            }
            if (! i.hasNext()){
                builder.append('}');
                break;
            }
            builder.append(',').append(' ');
        }
        }
        builder.append('}');
        return builder.toString();
    }
}