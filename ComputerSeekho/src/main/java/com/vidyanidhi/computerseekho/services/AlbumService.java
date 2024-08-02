package com.vidyanidhi.computerseekho.services;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.vidyanidhi.computerseekho.entities.Album;
import com.vidyanidhi.computerseekho.manager.AlbumManager;

	@Service
	public class AlbumService implements AlbumManager{
		
		@Autowired
		AlbumRepository repository;
		
		public void addAlbum(Album album) {
			repository.save(album);
		}
		
		public List<Album> getAlbum() {
				// TODO Auto-generated method stub
			return repository.findAll();
				
		}
		public void delete(int id) {
			repository.deleteById(id);
		}
		
		public Optional<Album> getSelected(String cat) {
			// TODO Auto-generated method stub
			return repository.cattype(cat);
		}
//
//        @Override
//        public void update(Album album, int id) {
//	     // TODO Auto-generated method stub
//           }
		
		public void update(Album album, int id) {
			// TODO Auto-generated method stub
			repository.update(album.getAlbumId(),album.getAlbumDescription(),album.isAlbum_is_active(),id);
		}

		
		//@Override
		//public Optional<Album> getSelected(String cat) {
		// TODO Auto-generated method stub
		//	return repository.listtype(cat);
		//}
	}

		

	

